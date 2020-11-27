package top.fallenangel.springboot.p2p.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import top.fallenangel.springboot.p2p.model.entity.RechargeRecord;
import top.fallenangel.springboot.p2p.model.mapper.RechargeRecordMapper;
import top.fallenangel.springboot.p2p.service.IRechargeService;
import top.fallenangel.springboot.p2p.util.RandomUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    /**
     * 生成充值记录
     *
     * @param uid           用户id
     * @param rechargeMoney 充值金额
     * @return 生成是否成功
     */
    @Override
    public RechargeRecord generateRechargeRecord(Integer uid, Double rechargeMoney) {
        Date now = new Date();

        RechargeRecord rechargeRecord = new RechargeRecord();
        rechargeRecord.setUid(uid);

        String rechargeNo = new SimpleDateFormat("yyyyMMddHHssSSS").format(now);
        rechargeNo = rechargeNo + RandomUtil.num(17);
        rechargeRecord.setRechargeNo(rechargeNo);

        rechargeRecord.setRechargeStatus("0");
        rechargeRecord.setRechargeMoney(rechargeMoney);
        rechargeRecord.setRechargeTime(now);
        rechargeRecord.setRechargeDesc("支付宝余额充值");

        int i = rechargeRecordMapper.insertSelective(rechargeRecord);
        if (i == 0) {
            rechargeRecord = null;
        }
        return rechargeRecord;
    }

    /**
     * 根据订单号查询充值记录
     *
     * @param outTradeNo 订单号
     * @return 充值记录
     */
    @Override
    public RechargeRecord getRechargeRecordByNo(String outTradeNo) {
        return rechargeRecordMapper.selectByTradeNo(outTradeNo);
    }

    /**
     * 更新充值记录
     *
     * @param record 充值记录
     */
    @Override
    public int updateRecharge(RechargeRecord record) {
        return rechargeRecordMapper.updateByPrimaryKeySelective(record);
    }
}
