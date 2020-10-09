package top.fallenangel.dao.impl;

import top.fallenangel.bean.User;
import top.fallenangel.dao.ILoginDao;
import top.fallenangel.util.DBUtil;

public class LoginDaoImpl implements ILoginDao {
    @Override
    public boolean userExist(User user) {
        DBUtil.connection("db_bjpowernode.properties", getClass().getClassLoader());
        int recordNum = DBUtil.queryRecordNum("SELECT count(*) FROM tb_user WHERE name=?", user.getName());
        DBUtil.close();
        return recordNum > 0;
    }

    @Override
    public User queryUserByName(String name) {
        DBUtil.connection("db_bjpowernode.properties", getClass().getClassLoader());
        User user = DBUtil.querySingleRecord(User.class, "SELECT name, age, sex, hobbies, email, phone, pwd FROM tb_user WHERE name=?", name);
        DBUtil.close();
        return user;
    }
}