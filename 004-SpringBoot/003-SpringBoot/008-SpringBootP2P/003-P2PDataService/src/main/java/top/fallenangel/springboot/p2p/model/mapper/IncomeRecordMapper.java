package top.fallenangel.springboot.p2p.model.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.fallenangel.springboot.p2p.model.entity.IncomeRecord;

import java.util.List;

/**
 * 收益记录dao接口
 *
 * @author FallenAngel
 */
@Repository
public interface IncomeRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IncomeRecord record);

    int insertSelective(IncomeRecord record);

    IncomeRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IncomeRecord record);

    int updateByPrimaryKey(IncomeRecord record);

    /**
     * 查询指定用户的最近收益记录
     *
     * @param uid 指定用户
     * @param num 查询数量
     * @return 指定用户的最近收益记录
     */
    List<IncomeRecord> queryLastIncomeRecord(@Param("uid") Integer uid, @Param("num") Integer num);

    /**
     * 查询全部已到期但还未返现的计划
     *
     * @param status 计划状态
     * @return 全部已到期但还未返现的计划
     */
    List<IncomeRecord> selectIncomeRecordByStatus(int status);
}