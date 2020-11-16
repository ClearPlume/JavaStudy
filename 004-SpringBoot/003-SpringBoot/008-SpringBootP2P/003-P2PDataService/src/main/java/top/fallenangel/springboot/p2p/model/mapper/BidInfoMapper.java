package top.fallenangel.springboot.p2p.model.mapper;

import org.springframework.stereotype.Repository;
import top.fallenangel.springboot.p2p.model.entity.BidInfo;

@Repository
public interface BidInfoMapper {
    int insert(BidInfo record);

    int insertSelective(BidInfo record);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BidInfo record);

    int updateByPrimaryKey(BidInfo record);

    BidInfo selectByPrimaryKey(Integer id);

    double selectTotalDealMoney();
}