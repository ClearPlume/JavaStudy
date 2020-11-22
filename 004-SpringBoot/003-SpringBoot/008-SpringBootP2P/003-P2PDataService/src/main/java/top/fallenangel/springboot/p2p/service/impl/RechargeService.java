package top.fallenangel.springboot.p2p.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import top.fallenangel.springboot.p2p.model.entity.RechargeRecord;
import top.fallenangel.springboot.p2p.model.mapper.RechargeRecordMapper;
import top.fallenangel.springboot.p2p.service.IRechargeService;

import java.util.List;

/**
 * 充值服务接口
 *
 * @author FallenAngel
 */
@org.springframework.stereotype.Service
@Service(interfaceClass = IRechargeService.class, version = "1.0.0", timeout = 15000)
public class RechargeService implements IRechargeService {
    private final RechargeRecordMapper rechargeRecordMapper;

    public RechargeService(RechargeRecordMapper rechargeRecordMapper) {
        this.rechargeRecordMapper = rechargeRecordMapper;
    }

    /**
     * 查询指定用户最近充值记录
     *
     * @param uid 用户id
     * @param num 查询记录数
     * @return 指定用户最近充值记录
     */
    @Override
    public List<RechargeRecord> queryLastRecharges(Integer uid, int num) {
        return rechargeRecordMapper.queryLastRecharges(uid, num);
    }
}
