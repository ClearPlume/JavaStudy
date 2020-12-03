package com.bjpowernode.model.dao;

import com.bjpowernode.model.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(int[] userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    User login(User record);

    List<User> selectAll();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 数据库中的用户。不存在名为“username”的用户则返回null
     */
    User selectByUsername(String username);
}
