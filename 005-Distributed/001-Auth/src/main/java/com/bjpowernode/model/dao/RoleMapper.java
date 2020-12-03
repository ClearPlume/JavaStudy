package com.bjpowernode.model.dao;

import com.bjpowernode.model.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(int[] roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    List<Role> selectAll();

    List<Role> listByUser(Integer userId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}
