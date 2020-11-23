package top.fallenangel.springboot.p2p.timer;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.fallenangel.springboot.p2p.service.IIncomeRecordService;

@SuppressWarnings("unused")
@Component
public class SpringTask {
    @Reference(interfaceClass = IIncomeRecordService.class, version = "1.0.0", timeout = 15000)
    private IIncomeRecordService incomeRecordService;

    /**
     * 生成收益计划
     */
    @Scheduled(fixedDelay = 5000)
    public void generateIncomePlan() {
        incomeRecordService.generateIncomePlan();
    }

    /**
     * 收益返现
     */
    @Scheduled(fixedDelay = 5000)
    public void checkRecurrence() {
        incomeRecordService.checkRecurrence();
    }
}
