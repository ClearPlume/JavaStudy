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




}
