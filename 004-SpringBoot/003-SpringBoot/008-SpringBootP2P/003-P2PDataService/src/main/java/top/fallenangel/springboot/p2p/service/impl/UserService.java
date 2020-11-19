package top.fallenangel.springboot.p2p.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;
import top.fallenangel.springboot.p2p.common.Constants;
import top.fallenangel.springboot.p2p.model.entity.User;
import top.fallenangel.springboot.p2p.model.mapper.FinanceAccountMapper;
import top.fallenangel.springboot.p2p.model.mapper.UserMapper;
import top.fallenangel.springboot.p2p.service.IUserService;
import top.fallenangel.springboot.p2p.util.RedisUtil;

import java.util.Date;

@org.springframework.stereotype.Service
@Service(interfaceClass = IUserService.class, version = "1.0.0", timeout = 15000)
public class UserService implements IUserService {
    private final UserMapper userMapper;
    private final FinanceAccountMapper financeAccountMapper;
    private final RedisUtil redisUtil;

    public UserService(UserMapper userMapper, FinanceAccountMapper financeAccountMapper, RedisUtil redisUtil) {
        this.userMapper = userMapper;
        this.financeAccountMapper = financeAccountMapper;
        this.redisUtil = redisUtil;
    }

    // 查询平台用户数
    @Override
    public int queryTotalUser() {
        return Integer.parseInt(redisUtil.getValueFromRedis(Constants.TOTAL_USER, () -> String.valueOf(userMapper.count())));
    }

    // 查询手机号数量
    @Override
    public int queryPhoneNum(String phone) {
        return userMapper.selectPhoneCount(phone);
    }

    // 在用户表中新增用户，同时赠送888大礼包
    @Override
    @Transactional
    public User register(String phone, String pwd) {
        User user = new User();
        user.setPhone(phone);
        user.setLoginPassword(pwd);
        user.setAddTime(new Date());
        userMapper.insertSelective(user);
        financeAccountMapper.registerGift(user.getId(), 888);
        return user;
    }
}
