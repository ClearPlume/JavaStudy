package com.bjpowernode.model.dao;

import com.bjpowernode.entity.UserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMapper {

    int deleteByPrimaryKey(Integer userRoleId);

    int deleteByUser(int userId);

    int insert(UserRole record);

    int insertBatch(@Param("userId") int userId, @Param("roleIds") int[] roleIds);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer userRoleId);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}