package com.bjpowernode.service.impl;

import com.bjpowernode.model.dao.UserMapper;
import com.bjpowernode.model.entity.User;
import com.bjpowernode.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService
{
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper)
    {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> list()
    {
        return userMapper.selectAll();
    }

    @Override
    public User get(int userId)
    {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public User login(User user)
    {
        return userMapper.login(user);
    }

    @Override
    public void save(User user)
    {
        userMapper.insertSelective(user);
    }

    @Override
    public void update(User user)
    {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void delete(int[] userId)
    {
        userMapper.deleteByPrimaryKey(userId);
    }

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 数据库中的用户。不存在名为“username”的用户则返回null
     */
    @Override
    public User get(String username)
    {
        return userMapper.selectByUsername(username);
    }

    /**
     * 根据用户id查询用户所有的权限Code
     *
     * @param userId 用户id
     * @return 权限Code列表
     */
    @Override
    public List<String> listAuthCode(int userId)
    {
        return userMapper.selectAllAuthCodeById(userId);
    }
}
