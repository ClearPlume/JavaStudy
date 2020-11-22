package top.fallenangel.springboot.p2p.model.mapper;

import org.springframework.stereotype.Repository;
import top.fallenangel.springboot.p2p.model.entity.IncomeRecord;

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
}