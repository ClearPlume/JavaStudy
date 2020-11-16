package top.fallenangel.springboot.p2p.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import top.fallenangel.springboot.p2p.common.Constant;
import top.fallenangel.springboot.p2p.model.mapper.BidInfoMapper;
import top.fallenangel.springboot.p2p.service.IBidInfoService;
import top.fallenangel.springboot.p2p.util.RedisUtil;

@org.springframework.stereotype.Service
@Service(interfaceClass = IBidInfoService.class, version = "1.0.0", timeout = 15000)
public class BidInfoService implements IBidInfoService {
    private final BidInfoMapper bidInfoMapper;
    private final RedisUtil redisUtil;

    public BidInfoService(BidInfoMapper bidInfoMapper, RedisUtil redisUtil) {
        this.bidInfoMapper = bidInfoMapper;
        this.redisUtil = redisUtil;
    }

    @Override
    public double queryTotalDealMoney() {
        return Double.parseDouble(redisUtil.getValueFromRedis(Constant.TOTAL_DEAL_MONEY, () -> String.valueOf(bidInfoMapper.selectTotalDealMoney())));
    }
}
