package top.fallenangel.spring.mvc.model.dao;

import top.fallenangel.spring.mvc.entity.User;

public interface IUserDao {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    User selectUserByName(String userName);

    User selectUserByNameAndPwd(String userName, String userPwd);
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}