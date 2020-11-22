package top.fallenangel.springboot.p2p.service;

import top.fallenangel.springboot.p2p.model.entity.IncomeRecord;

/**
 * 收益记录服务接口
 *
 * @author FallenAngel
 */
public interface IIncomeRecordService {
    /**
     * 新增收益记录
     *
     * @param incomeRecord 收益记录
     */
    void add(IncomeRecord incomeRecord);
}
