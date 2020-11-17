package top.fallenangel.springboot.p2p.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    @Override
    public PageInfo<LoanInfo> queryProductInfo(Integer productType, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return PageInfo.of(loanInfoMapper.selectProductInfoByType(productType));
    }

    @Override
    public int queryTotalPage(Integer productType, Integer pageSize) {
        int total = loanInfoMapper.selectTotalByType(productType);
        return total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
    }
}
