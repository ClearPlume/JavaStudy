package top.fallenangel.springboot.p2p.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import top.fallenangel.springboot.p2p.common.Constants;
import top.fallenangel.springboot.p2p.common.Result;
import top.fallenangel.springboot.p2p.model.entity.BidInfo;
import top.fallenangel.springboot.p2p.model.entity.FinanceAccount;
import top.fallenangel.springboot.p2p.model.entity.LoanInfo;
import top.fallenangel.springboot.p2p.model.mapper.BidInfoMapper;
import top.fallenangel.springboot.p2p.model.mapper.FinanceAccountMapper;
import top.fallenangel.springboot.p2p.model.mapper.LoanInfoMapper;
import top.fallenangel.springboot.p2p.service.IBidInfoService;
import top.fallenangel.springboot.p2p.util.RedisUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

// 投资记录Service
@org.springframework.stereotype.Service
@Service(interfaceClass = IBidInfoService.class, version = "1.0.0", timeout = 15000)
public class BidInfoService implements IBidInfoService {
    private final BidInfoMapper bidInfoMapper;
    private final FinanceAccountMapper financeAccountMapper;
    private final LoanInfoMapper loanInfoMapper;
    private final RedisUtil redisUtil;

    public BidInfoService(BidInfoMapper bidInfoMapper, FinanceAccountMapper financeAccountMapper, LoanInfoMapper loanInfoMapper, RedisUtil redisUtil) {
        this.bidInfoMapper = bidInfoMapper;
        this.financeAccountMapper = financeAccountMapper;
        this.loanInfoMapper = loanInfoMapper;
        this.redisUtil = redisUtil;
    }

    /**
     * 查询平台总成交额
     *
     * @return 平台总成交额
     */
    @Override
    public double queryTotalDealMoney() {
        return Double.parseDouble(redisUtil.getValueFromRedis(Constants.TOTAL_DEAL_MONEY, () -> String.valueOf(bidInfoMapper.selectTotalDealMoney())));
    }

    /**
     * 查询指定页产品投资记录
     *
     * @param loanId   产品Id
     * @param page     指定页
     * @param pageSize 页面大小
     * @return 产品投资记录(投资人 投资金额 投资时间)
     */
    @Override
    public List<Map<String, Object>> queryBidRecord(Integer loanId, Integer page, Integer pageSize) {
        List<Map<String, Object>> records;

        if (page == 0) {
            records = new ArrayList<>();
        } else {
            records = bidInfoMapper.selectBidRecordByLoanId(loanId, (page - 1) * pageSize, pageSize);
        }
        for (Map<String, Object> record : records) {
            record.put("bid_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(record.get("bid_time")));
        }
        return records;
    }

    /**
     * 根据产品id查询其投资记录
     *
     * @param loanId 产品id
     * @return 某产品投资记录
     */
    @Override
    public List<BidInfo> queryBidRecord(Integer loanId) {
        return bidInfoMapper.selectAllBidRecordByLoanId(loanId);
    }

    /**
     * 查询产品的投资记录总页数
     *
     * @param loanId   产品id
     * @param pageSize 页面大小
     * @return 页数
     */
    @Override
    public int queryLoanBidPages(Integer loanId, Integer pageSize) {
        int count = bidInfoMapper.count(loanId);
        return count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    }

    /**
     * 用户投资
     * <p>
     * 返回值中的code：1：当前未登录 2：余额不足 3：产品可投金额不足 4：产品已满标 5：系统维护中
     *
     * @param userId   用户Id
     * @param loanId   投资产品
     * @param bidMoney 投资金额
     * @return 投资结果
     */
    @Override
    @Transactional
    public Map<String, Object> invest(int userId, int loanId, double bidMoney) {
        int loanVersion = loanInfoMapper.selectByPrimaryKey(loanId).getVersion();
        int num = 0;

        // 帐户余额
        FinanceAccount financeAccount = financeAccountMapper.selectFinanceAccountByUserId(userId);
        Double availableMoney = financeAccount.getAvailableMoney();
        if (availableMoney < bidMoney) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(2, "您的帐户余额不足，请充值！");
        }

        financeAccount.setAvailableMoney(availableMoney - bidMoney);
        try {
            num = financeAccountMapper.updateByPrimaryKeySelective(financeAccount);
        } catch (RuntimeException e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        if (num == 0) {
            return Result.error(5, "系统维护中...");
        }

        // 操作投资产品
        LoanInfo loanInfo = loanInfoMapper.selectByPrimaryKey(loanId);
        loanInfo.setVersion(loanVersion);
        Double leftProductMoney = loanInfo.getLeftProductMoney();

        // 产品剩余可投金额是否足够
        if (leftProductMoney < bidMoney) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(3, "产品可投金额仅剩" + leftProductMoney + "！");
        }
        // 产品是否已满标
        if (leftProductMoney == 0) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(4, "产品已满标！");
        }
        loanInfo.setLeftProductMoney(leftProductMoney - bidMoney);
        // 投资后，产品是否已满标
        if (loanInfo.getLeftProductMoney() == 0) {
            loanInfo.setProductStatus(1);
            loanInfo.setProductFullTime(new Date());
        }
        try {
            num = loanInfoMapper.updateByPrimaryKeySelective(loanInfo);
        } catch (RuntimeException e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        if (num == 0) {
            return Result.error(5, "系统维护中...");
        }

        // 新增投资记录
        BidInfo bidInfo = new BidInfo();
        bidInfo.setUid(userId);
        bidInfo.setLoanId(loanId);
        bidInfo.setBidMoney(bidMoney);
        bidInfo.setBidTime(new Date());
        bidInfo.setBidStatus(1);
        if (bidInfoMapper.insertSelective(bidInfo) == 0) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.error(5, "系统维护中...");
        }
        return Result.success();
    }
}
