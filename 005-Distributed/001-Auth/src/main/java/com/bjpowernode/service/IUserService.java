package com.bjpowernode.service;

import com.bjpowernode.model.entity.User;

import java.util.List;

public interface IUserService {

    List<User> list();

    User login(User user);

    User get(int userId);

    void save(User user);

    void update(User user);

    void delete(int[] userId);

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 数据库中的用户。不存在名为“username”的用户则返回null
     */
    User get(String username);
}
