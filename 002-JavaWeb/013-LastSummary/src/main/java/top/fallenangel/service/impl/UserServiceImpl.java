package top.fallenangel.service.impl;

import top.fallenangel.bean.User;
import top.fallenangel.mapper.UserMapper;
import top.fallenangel.service.IUserService;
import top.fallenangel.util.MybatisUtil;

public class UserServiceImpl implements IUserService {
    private final UserMapper userMapper;

    {
        MybatisUtil.initial(MybatisUtil.getResource("MybatisConfig.xml"));
        userMapper = MybatisUtil.getMapper(UserMapper.class);
    }

    @Override
    public User login(String name, String pwd) {
        return userMapper.login(name, pwd);
    }

    @Override
    public User query(String userName) {
        return userMapper.query(userName);
    }
}