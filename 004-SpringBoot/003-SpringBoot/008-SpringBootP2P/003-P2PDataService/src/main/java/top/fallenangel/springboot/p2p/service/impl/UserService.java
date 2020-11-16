package top.fallenangel.springboot.p2p.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import top.fallenangel.springboot.p2p.common.Constant;
import top.fallenangel.springboot.p2p.model.mapper.UserMapper;
import top.fallenangel.springboot.p2p.service.IUserService;
import top.fallenangel.springboot.p2p.util.RedisUtil;

@org.springframework.stereotype.Service
@Service(interfaceClass = IUserService.class, version = "1.0.0", timeout = 15000)
public class UserService implements IUserService {
    private final UserMapper userMapper;
    private final RedisUtil redisUtil;

    public UserService(UserMapper userMapper, RedisUtil redisUtil) {
        this.userMapper = userMapper;
        this.redisUtil = redisUtil;
    }

    @Override
    public int queryTotalUser() {
        return Integer.parseInt(redisUtil.getValueFromRedis(Constant.TOTAL_USER, () -> String.valueOf(userMapper.count())));
    }
}
