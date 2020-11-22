package top.fallenangel.springboot.p2p.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import top.fallenangel.springboot.p2p.model.entity.IncomeRecord;
import top.fallenangel.springboot.p2p.model.mapper.IncomeRecordMapper;
import top.fallenangel.springboot.p2p.service.IIncomeRecordService;

import java.util.List;

/**
 * 收益记录服务实现类
 *
 * @author FallenAngel
 */
@org.springframework.stereotype.Service
@Service(interfaceClass = IIncomeRecordService.class, version = "1.0.0", timeout = 15000)
public class IncomeRecordService implements IIncomeRecordService {
    private final IncomeRecordMapper incomeRecordMapper;

    public IncomeRecordService(IncomeRecordMapper incomeRecordMapper) {
        this.incomeRecordMapper = incomeRecordMapper;
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
     * 查询指定用户的最近投资记录
     *
     * @param uid 指定用户
     * @param num 查询数量
     * @return 指定用户的最近收益记录
     */
    @Override
    public List<IncomeRecord> queryLastIncomeRecord(Integer uid, Integer num) {
        return incomeRecordMapper.queryLastIncomeRecord(uid, num);
    }
}
