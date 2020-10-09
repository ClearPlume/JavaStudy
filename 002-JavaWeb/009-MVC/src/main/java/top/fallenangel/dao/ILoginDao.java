package top.fallenangel.dao;

import top.fallenangel.bean.User;

public interface ILoginDao {
    boolean userExist(User user);
    User queryUserByName(String name);
}