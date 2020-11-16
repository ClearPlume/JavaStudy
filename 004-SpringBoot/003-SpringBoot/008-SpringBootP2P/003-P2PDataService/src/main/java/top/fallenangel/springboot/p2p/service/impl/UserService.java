package top.fallenangel.springboot.p2p.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import top.fallenangel.springboot.p2p.model.mapper.UserMapper;
import top.fallenangel.springboot.p2p.service.IUserService;

@org.springframework.stereotype.Service
@Service(interfaceClass = IUserService.class, version = "1.0.0", timeout = 15000)
public class UserService implements IUserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int queryTotalUser() {
        return userMapper.count();
    }
}
