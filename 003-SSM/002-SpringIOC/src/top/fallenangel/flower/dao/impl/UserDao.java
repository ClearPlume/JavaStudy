package top.fallenangel.flower.dao.impl;

import org.springframework.stereotype.Repository;
import top.fallenangel.flower.dao.IUserDao;

@Repository
public class UserDao implements IUserDao {
    @Override
    public void insert() {
        System.out.println("存数据");
    }
}