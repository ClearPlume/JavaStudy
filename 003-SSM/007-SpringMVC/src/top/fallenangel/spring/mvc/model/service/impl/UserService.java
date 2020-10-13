package top.fallenangel.spring.mvc.model.service.impl;

import org.springframework.stereotype.Service;
import top.fallenangel.spring.mvc.entity.User;
import top.fallenangel.spring.mvc.model.dao.IUserDao;
import top.fallenangel.spring.mvc.model.service.IUserService;

@Service
public class UserService implements IUserService {
    private final IUserDao userDao;

    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User get(String userName) {
        return userDao.selectUserByName(userName);
    }

    @Override
    public User get(String userName, String userPwd) {
        return userDao.selectUserByNameAndPwd(userName, userPwd);
    }

    @Override
    public void save(User user) {
        userDao.insertSelective(user);
    }
}