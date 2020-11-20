package top.fallenangel.springboot.p2p.model.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.fallenangel.springboot.p2p.model.entity.FinanceAccount;

@Repository
public interface FinanceAccountMapper {
    int insert(FinanceAccount record);

    int insertSelective(FinanceAccount record);

    /**
     * 赠送大礼包
     *
     * @param userId     送给哪个用户
     * @param amount 送多少
     */
    int registerGift(@Param("userId") Integer userId, @Param("amount") int amount);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FinanceAccount record);

    int updateByPrimaryKey(FinanceAccount record);

    FinanceAccount selectByPrimaryKey(Integer id);

    /**
     * 根据用户id查询帐户余额
     *
     * @param uId 用户id
     * @return 余额
     */
    int selectAccountAmountByUserId(@Param("uId") Integer uId);
}