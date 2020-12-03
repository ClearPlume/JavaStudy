package com.bjpowernode.service.impl;

import com.bjpowernode.model.dao.UserMapper;
import com.bjpowernode.model.entity.User;
import com.bjpowernode.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.selectAll();
    }

    @Override
    public User get(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public void save(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void delete(int[] userId) {
        userMapper.deleteByPrimaryKey(userId);
    }
}
