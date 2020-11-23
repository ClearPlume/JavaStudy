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

    /**
     * 查询产品平均收益率
     *
     * @return 平均收益率
     */
    double selectAvgRate();

    /**
     * 根据指定参数查询产品信息
     *
     * @param param 参数
     * @return 满足条件的产品信息
     */
    List<LoanInfo> selectProductInfo(Map<String, Object> param);

    /**
     * 查询某类型产品信息
     *
     * @param productType 产品类型
     * @return 某类型产品
     */
    List<LoanInfo> selectProductInfoByType(@Param("productType") Integer productType);

    /**
     * 查询某类型产品总数
     *
     * @param productType 产品类型
     * @return 总数
     */
    int selectTotalByType(@Param("productType") Integer productType);

    /**
     * 按状态查找产品
     *
     * @param status 产品状态
     * @return 指定状态的产品
     */
    List<LoanInfo> selectLoanByStatus(@Param("status") int status);
}