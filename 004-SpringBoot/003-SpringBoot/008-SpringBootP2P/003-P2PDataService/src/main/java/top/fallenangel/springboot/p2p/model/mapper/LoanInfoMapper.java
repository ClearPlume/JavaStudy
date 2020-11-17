package top.fallenangel.springboot.p2p.model.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.fallenangel.springboot.p2p.model.entity.LoanInfo;

import java.util.List;
import java.util.Map;

@Repository
public interface LoanInfoMapper {
    int insert(LoanInfo record);

    int insertSelective(LoanInfo record);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoanInfo record);

    int updateByPrimaryKey(LoanInfo record);

    LoanInfo selectByPrimaryKey(Integer id);

    double selectAvgRate();

    List<LoanInfo> selectProductInfo(Map<String, Object> param);

    List<LoanInfo> selectProductInfoByType(@Param("productType") Integer productType);

    int selectTotalByType(@Param("productType") Integer productType);
}