package top.fallenangel.service.impl;

import top.fallenangel.bean.User;
import top.fallenangel.dao.ILoginDao;
import top.fallenangel.dao.impl.LoginDaoImpl;
import top.fallenangel.service.ILoginService;

public class LoginServiceImpl implements ILoginService {
    private final ILoginDao loginDao = new LoginDaoImpl();

    @Override
    public User login(User loggingUser) {
        if (loginDao.userExist(loggingUser)) {
            return loginDao.queryUserByName(loggingUser.getName());
        } else {
            return null;
        }
    }
}