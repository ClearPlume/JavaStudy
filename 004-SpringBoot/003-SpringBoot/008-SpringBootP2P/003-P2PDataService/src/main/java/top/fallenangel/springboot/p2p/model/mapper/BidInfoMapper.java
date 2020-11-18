package top.fallenangel.springboot.p2p.model.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.fallenangel.springboot.p2p.model.entity.BidInfo;

import java.util.List;
import java.util.Map;

@Repository
public interface BidInfoMapper {
    int insert(BidInfo record);

    int insertSelective(BidInfo record);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BidInfo record);

    int updateByPrimaryKey(BidInfo record);

    BidInfo selectByPrimaryKey(Integer id);

    /**
     * 查询总成交金额
     *
     * @return 总成交金额
     */
    double selectTotalDealMoney();

    /**
     * 查询指定页的产品投资记录
     *
     * @param loanId   产品Id
     * @param startRow 起始行数
     * @param pageSize 页面大小
     * @return 产品投资记录(投资人 投资金额 投资时间)
     */
    List<Map<String, Object>> selectBidRecordByLoanId(@Param("loanId") Integer loanId, @Param("startRow") Integer startRow, @Param("pageSize") Integer pageSize);

    /**
     * 查询产品的投资记录数
     *
     * @param loanId 产品id
     * @return 投资记录数
     */
    int count(@Param("loanId") Integer loanId);
}