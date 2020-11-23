package top.fallenangel.springboot.p2p.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import top.fallenangel.springboot.p2p.model.entity.BidInfo;
import top.fallenangel.springboot.p2p.model.entity.IncomeRecord;
import top.fallenangel.springboot.p2p.model.entity.LoanInfo;
import top.fallenangel.springboot.p2p.model.mapper.BidInfoMapper;
import top.fallenangel.springboot.p2p.model.mapper.FinanceAccountMapper;
import top.fallenangel.springboot.p2p.model.mapper.IncomeRecordMapper;
import top.fallenangel.springboot.p2p.model.mapper.LoanInfoMapper;
import top.fallenangel.springboot.p2p.service.IIncomeRecordService;

import java.util.*;

/**
 * 收益记录服务实现类
 *
 * @author FallenAngel
 */
@Slf4j
@org.springframework.stereotype.Service
@Service(interfaceClass = IIncomeRecordService.class, version = "1.0.0", timeout = 15000)
public class IncomeRecordService implements IIncomeRecordService {
    private final LoanInfoMapper loanInfoMapper;
    private final BidInfoMapper bidInfoMapper;
    private final IncomeRecordMapper incomeRecordMapper;
    private final FinanceAccountMapper financeAccountMapper;

    public IncomeRecordService(LoanInfoMapper loanInfoMapper, BidInfoMapper bidInfoMapper, IncomeRecordMapper incomeRecordMapper, FinanceAccountMapper financeAccountMapper) {
        this.loanInfoMapper = loanInfoMapper;
        this.bidInfoMapper = bidInfoMapper;
        this.incomeRecordMapper = incomeRecordMapper;
        this.financeAccountMapper = financeAccountMapper;
    }

    /**
     * 新增收益记录
     *
     * @param incomeRecord 收益记录
     */
    @Override
    public void add(IncomeRecord incomeRecord) {
        incomeRecordMapper.insertSelective(incomeRecord);
    }

    /**
     * 查询指定用户的最近收益记录
     *
     * @param uid 指定用户
     * @param num 查询数量
     * @return 指定用户的最近收益记录
     */
    @Override
    public List<IncomeRecord> queryLastIncomeRecord(Integer uid, Integer num) {
        return incomeRecordMapper.queryLastIncomeRecord(uid, num);
    }

    /**
     * 生成收益计划
     */
    @Override
    @Transactional
    public void generateIncomePlan() {
        log.info("生成收益计划...");
        // 查询全部<已满标但没有生成收益计划>的产品
        List<LoanInfo> loanInfos = loanInfoMapper.selectLoanByStatus(1);

        for (LoanInfo loanInfo : loanInfos) {
            // 针对每一个产品，查找它的全部投资记录
            List<BidInfo> records = bidInfoMapper.selectAllBidRecordByLoanId(loanInfo.getId());

            for (BidInfo record : records) {
                // 针对每一条投资记录，生成收益计划
                IncomeRecord incomeRecord = new IncomeRecord();

                incomeRecord.setBidId(record.getId());
                incomeRecord.setBidMoney(record.getBidMoney());
                incomeRecord.setLoanInfo(loanInfo);
                incomeRecord.setUid(record.getUid());
                incomeRecord.setIncomeStatus(0);

                // 设置收益返现时间
                Calendar calendar = Calendar.getInstance(Locale.CHINA);
                calendar.setTime(loanInfo.getProductFullTime());
                int field;
                if (loanInfo.getProductType() == 0) {
                    field = Calendar.DAY_OF_YEAR;
                } else {
                    field = Calendar.MONTH;
                }
                calendar.add(field, loanInfo.getCycle());
                incomeRecord.setIncomeDate(calendar.getTime());

                // 设置预计收入金额 rate / 100 / 365 * cycle * Number(bidMoney)
                double incomeMoney;
                if (loanInfo.getProductType() == 0) {
                    incomeMoney = loanInfo.getRate() / 100 / 365 * loanInfo.getCycle() * record.getBidMoney();
                } else {
                    incomeMoney = loanInfo.getRate() / 100 / 365 * loanInfo.getCycle() * 30 * record.getBidMoney();
                }
                incomeRecord.setIncomeMoney(incomeMoney);

                // 插入收益计划
                incomeRecordMapper.insertSelective(incomeRecord);
            }
            // 更新产品状态
            loanInfo.setProductStatus(2);
            loanInfoMapper.updateByPrimaryKeySelective(loanInfo);
        }
    }

    /**
     * 收益返现
     */
    @Override
    @Transactional
    public void checkRecurrence() {
        log.info("完成收益返现...");
        // 查询全部已到期但还未返现的计划
        List<IncomeRecord> incomeRecords = incomeRecordMapper.selectIncomeRecordByStatus(0);

        for (IncomeRecord incomeRecord : incomeRecords) {
            // 针对每一个计划，将本金+利息存入帐户
            Map<String, Object> param = new HashMap<>();
            param.put("uid", incomeRecord.getUid());
            param.put("bidMoney", incomeRecord.getBidMoney());
            param.put("incomeMoney", incomeRecord.getIncomeMoney());
            int num = financeAccountMapper.updateAccountByUid(param);
            if (num < 1) {
                throw new RuntimeException("返现失败");
            }

            // 将计划状态改为1
            incomeRecord.setIncomeStatus(1);
            incomeRecordMapper.updateByPrimaryKeySelective(incomeRecord);
        }

    }
}
