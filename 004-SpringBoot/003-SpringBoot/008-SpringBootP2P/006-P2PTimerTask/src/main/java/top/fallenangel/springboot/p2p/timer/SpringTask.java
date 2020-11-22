package top.fallenangel.springboot.p2p.timer;

import com.alibaba.dubbo.config.annotation.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.fallenangel.springboot.p2p.model.entity.BidInfo;
import top.fallenangel.springboot.p2p.model.entity.IncomeRecord;
import top.fallenangel.springboot.p2p.model.entity.LoanInfo;
import top.fallenangel.springboot.p2p.service.IBidInfoService;
import top.fallenangel.springboot.p2p.service.IIncomeRecordService;
import top.fallenangel.springboot.p2p.service.ILoanInfoService;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@SuppressWarnings("unused")
@Slf4j
@Component
public class SpringTask {
    @Reference(interfaceClass = ILoanInfoService.class, version = "1.0.0", timeout = 15000)
    private ILoanInfoService loanInfoService;

    @Reference(interfaceClass = IBidInfoService.class, version = "1.0.0", timeout = 15000)
    private IBidInfoService bidInfoService;

    @Reference(interfaceClass = IIncomeRecordService.class, version = "1.0.0", timeout = 15000)
    private IIncomeRecordService iIncomeRecordService;

    /**
     * 生成收益计划
     */
    // 开启定时任务：每5秒执行一次
    @Scheduled(cron = "0/5 * * * * ?", zone = "Asia/Shanghai")
    public void generateIncomePlan() {
        List<LoanInfo> loanInfos = loanInfoService.queryFullyLoan();

        if (!loanInfos.isEmpty()) {
            for (LoanInfo loanInfo : loanInfos) {
                log.info("处理第" + loanInfos.indexOf(loanInfo) + 1 + "个已满标未生成收益记划的产品...");
                List<BidInfo> records = bidInfoService.queryBidRecord(loanInfo.getId());

                for (BidInfo record : records) {
                    IncomeRecord incomeRecord = new IncomeRecord();

                    incomeRecord.setBidId(record.getId());
                    incomeRecord.setBidMoney(record.getBidMoney());
                    incomeRecord.setLoanId(loanInfo.getId());
                    incomeRecord.setUid(record.getUid());
                    incomeRecord.setIncomeStatus(0);

                    // 设置时间
                    Calendar calendar = Calendar.getInstance(Locale.CHINA);
                    int field;
                    if (loanInfo.getProductType() == 0) {
                        field = Calendar.DAY_OF_MONTH;
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

                    iIncomeRecordService.add(incomeRecord);
                }
                loanInfo.setProductStatus(2);
                loanInfoService.modify(loanInfo);
            }
        } else {
            log.info("没有已满标未生成收益记划的产品...");
        }
    }
}
