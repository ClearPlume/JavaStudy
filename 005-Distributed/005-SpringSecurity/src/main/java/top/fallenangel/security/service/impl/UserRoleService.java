package top.fallenangel.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.fallenangel.security.model.dao.UserRoleMapper;
import top.fallenangel.security.service.IUserRoleService;

@Service
public class UserRoleService implements IUserRoleService
{
    @Autowired
    private UserRoleMapper userRoleMapper;

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
