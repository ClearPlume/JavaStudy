package top.fallenangel.springboot.p2p.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import top.fallenangel.springboot.p2p.model.mapper.BidInfoMapper;
import top.fallenangel.springboot.p2p.service.IBidInfoService;

@org.springframework.stereotype.Service
@Service(interfaceClass = IBidInfoService.class, version = "1.0.0", timeout = 15000)
public class BidInfoService implements IBidInfoService {
    private final BidInfoMapper bidInfoMapper;

    public BidInfoService(BidInfoMapper bidInfoMapper) {
        this.bidInfoMapper = bidInfoMapper;
    }

    @Override
    public double queryTotalDealMoney() {
        return bidInfoMapper.selectTotalDealMoney();
    }
}
