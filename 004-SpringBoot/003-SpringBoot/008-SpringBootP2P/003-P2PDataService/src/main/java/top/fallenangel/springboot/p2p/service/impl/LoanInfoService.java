package top.fallenangel.springboot.p2p.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import top.fallenangel.springboot.p2p.common.Constant;
import top.fallenangel.springboot.p2p.model.entity.LoanInfo;
import top.fallenangel.springboot.p2p.model.mapper.LoanInfoMapper;
import top.fallenangel.springboot.p2p.service.ILoanInfoService;
import top.fallenangel.springboot.p2p.util.RedisUtil;

import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
@Service(interfaceClass = ILoanInfoService.class, version = "1.0.0", timeout = 15000)
public class LoanInfoService implements ILoanInfoService {
    private final LoanInfoMapper loanInfoMapper;
    private final RedisUtil redisUtil;

    public LoanInfoService(LoanInfoMapper loanInfoMapper, RedisUtil redisUtil) {
        this.loanInfoMapper = loanInfoMapper;
        this.redisUtil = redisUtil;
    }

    @Override
    public double queryAvgRate() {
        return Double.parseDouble(redisUtil.getValueFromRedis(Constant.AVG_RATE, () -> String.valueOf(loanInfoMapper.selectAvgRate())));
    }

    @Override
    public List<LoanInfo> queryProductInfo(Map<String, Object> param) {
        return loanInfoMapper.selectProductInfo(param);
    }
}
