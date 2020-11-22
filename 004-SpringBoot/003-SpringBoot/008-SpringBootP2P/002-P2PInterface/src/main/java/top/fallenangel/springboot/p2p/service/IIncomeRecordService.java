package top.fallenangel.springboot.p2p.service;

import top.fallenangel.springboot.p2p.model.entity.IncomeRecord;

import java.util.List;

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

    /**
     * 查询指定用户的最近收益记录
     *
     * @param uid 指定用户
     * @param num 查询数量
     * @return 指定用户的最近收益记录
     */
    List<IncomeRecord> queryLastIncomeRecord(Integer uid, Integer num);
}
