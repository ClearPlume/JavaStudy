package com.bjpowernode.service.impl;

import com.bjpowernode.model.dao.UserRoleMapper;
import com.bjpowernode.service.IUserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRoleService implements IUserRoleService
{
    private final UserRoleMapper userRoleMapper;

    public UserRoleService(UserRoleMapper userRoleMapper)
    {
        this.userRoleMapper = userRoleMapper;
    }

    @Override
    @Transactional
    public void update(int userId, int[] roleIds)
    {
        //删除旧角色
        userRoleMapper.deleteByUser(userId);

        //保存新角色
        if (roleIds != null && roleIds.length > 0)
        {
            userRoleMapper.insertBatch(userId, roleIds);
        }
    }
}
