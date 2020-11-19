package top.fallenangel.springboot.p2p.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.fallenangel.springboot.p2p.common.Constants;
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

    // 查询产品平均收益率
    @Override
    public double queryAvgRate() {
        return Double.parseDouble(redisUtil.getValueFromRedis(Constants.AVG_RATE, () -> String.valueOf(loanInfoMapper.selectAvgRate())));
    }

    // 根据指定参数查询产品信息
    @Override
    public List<LoanInfo> queryProductInfo(Map<String, Object> param) {
        return loanInfoMapper.selectProductInfo(param);
    }

    // 根据当前页面、页面大小查询指定类型的产品信息
    @Override
    public PageInfo<LoanInfo> queryProductInfo(Integer productType, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return PageInfo.of(loanInfoMapper.selectProductInfoByType(productType));
    }

    // 根据产品类型和页面大小查询总页数
    @Override
    public int queryTotalPage(Integer productType, Integer pageSize) {
        int total = loanInfoMapper.selectTotalByType(productType);
        return total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
    }

    // 根据id查询产品信息
    @Override
    public LoanInfo queryLoanInfo(Integer loanId) {
        return loanInfoMapper.selectByPrimaryKey(loanId);
    }
}
