package com.bjpowernode.service.impl;

import com.bjpowernode.model.dao.RoleAuthMapper;
import com.bjpowernode.model.dao.RoleMapper;
import com.bjpowernode.model.entity.Role;
import com.bjpowernode.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService implements IRoleService
{
    private final RoleMapper roleMapper;

    private final RoleAuthMapper roleAuthMapper;

    public RoleService(RoleMapper roleMapper, RoleAuthMapper roleAuthMapper)
    {
        this.roleMapper = roleMapper;
        this.roleAuthMapper = roleAuthMapper;
    }

    @Override
    public List<Role> list()
    {
        return roleMapper.selectAll();
    }

    @Override
    public List<Role> listByUser(int userId)
    {
        return roleMapper.listByUser(userId);
    }

    @Override
    public Role get(int roleId)
    {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public void save(Role role)
    {
        roleMapper.insert(role);
    }

    @Override
    public void update(Role role)
    {
        roleMapper.updateByPrimaryKey(role);
    }

    @Override
    @Transactional
    public void delete(int[] roleId)
    {
        roleAuthMapper.deleteByRoleBatch(roleId);
        roleMapper.deleteByPrimaryKey(roleId);
    }
}
