package top.fallenangel.flower.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fallenangel.flower.dao.IUserDao;
import top.fallenangel.flower.service.IUserService;

@Service
public class UserService implements IUserService {
    private final IUserDao userDao;

    @Autowired
    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void insert() {
        userDao.insert();
    }
}