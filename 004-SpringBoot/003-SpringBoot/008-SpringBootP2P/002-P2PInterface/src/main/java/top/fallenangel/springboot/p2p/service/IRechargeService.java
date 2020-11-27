package top.fallenangel.springboot.p2p.service;

import top.fallenangel.springboot.p2p.model.entity.RechargeRecord;

import java.util.List;

/**
 * 充值服务接口
 *
 * @author FallenAngel
 */
public interface IRechargeService {
    /**
     * 查询指定用户最近充值记录
     *
     * @param uid 用户id
     * @param num 查询记录数
     * @return 指定用户最近充值记录
     */
    List<RechargeRecord> queryLastRecharges(Integer uid, int num);

    /**
     * 生成充值记录
     *
     * @param uid           用户id
     * @param rechargeMoney 充值金额
     * @return 生成是否成功
     */
    RechargeRecord generateRechargeRecord(Integer uid, Double rechargeMoney);

    /**
     * 根据订单号查询充值记录
     *
     * @param outTradeNo 订单号
     */
    RechargeRecord getRechargeRecordByNo(String outTradeNo);

    /**
     * 更新充值记录
     *
     * @param record 充值记录
     */
    int updateRecharge(RechargeRecord record);
}
