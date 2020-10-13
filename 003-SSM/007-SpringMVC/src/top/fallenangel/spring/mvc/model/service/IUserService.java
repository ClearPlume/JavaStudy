package top.fallenangel.spring.mvc.model.service;

import top.fallenangel.spring.mvc.entity.User;

public interface IUserService {
    User get(String userName);

    User get(String userName, String userPwd);

    void save(User user);
}