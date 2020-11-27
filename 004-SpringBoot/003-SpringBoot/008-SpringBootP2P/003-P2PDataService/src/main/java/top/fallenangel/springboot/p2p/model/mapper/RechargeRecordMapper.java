package top.fallenangel.springboot.p2p.model.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.fallenangel.springboot.p2p.model.entity.RechargeRecord;

import java.util.List;

@Repository
public interface RechargeRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RechargeRecord record);

    int insertSelective(RechargeRecord record);

    RechargeRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RechargeRecord record);

    int updateByPrimaryKey(RechargeRecord record);

    /**
     * 查询指定用户最近充值记录
     *
     * @param uid 用户id
     * @param num 查询记录数
     * @return 指定用户最近充值记录
     */
    List<RechargeRecord> queryLastRecharges(@Param("uid") Integer uid, @Param("num") int num);

    /**
     * 根据订单号查询充值记录
     *
     * @param outTradeNo 订单号
     * @return 充值记录
     */
    RechargeRecord selectByTradeNo(String outTradeNo);
}