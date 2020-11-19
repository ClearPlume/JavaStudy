package top.fallenangel.springboot.p2p.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import top.fallenangel.springboot.p2p.common.Constants;
import top.fallenangel.springboot.p2p.model.mapper.BidInfoMapper;
import top.fallenangel.springboot.p2p.service.IBidInfoService;
import top.fallenangel.springboot.p2p.util.RedisUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
@Service(interfaceClass = IBidInfoService.class, version = "1.0.0", timeout = 15000)
public class BidInfoService implements IBidInfoService {
    private final BidInfoMapper bidInfoMapper;
    private final RedisUtil redisUtil;

    public BidInfoService(BidInfoMapper bidInfoMapper, RedisUtil redisUtil) {
        this.bidInfoMapper = bidInfoMapper;
        this.redisUtil = redisUtil;
    }

    // 查询平台总成交额
    @Override
    public double queryTotalDealMoney() {
        return Double.parseDouble(redisUtil.getValueFromRedis(Constants.TOTAL_DEAL_MONEY, () -> String.valueOf(bidInfoMapper.selectTotalDealMoney())));
    }

    // 查询指定页产品投资记录
    @Override
    public List<Map<String, Object>> queryBidRecord(Integer loanId, Integer page, Integer pageSize) {
        List<Map<String, Object>> records;

        if (page == 0) {
            records = new ArrayList<>();
        } else {
            records = bidInfoMapper.selectBidRecordByLoanId(loanId, (page - 1) * pageSize, pageSize);
        }
        for (Map<String, Object> record : records) {
            record.put("bid_time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(record.get("bid_time")));
        }
        return records;
    }

    // 投资记录总页数
    @Override
    public int queryLoanBidPages(Integer loanId, Integer pageSize) {
        int count = bidInfoMapper.count(loanId);
        return count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    }
}
