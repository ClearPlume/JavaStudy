package top.fallenangel.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.fallenangel.security.model.dao.RoleAuthMapper;
import top.fallenangel.security.model.dao.RoleMapper;
import top.fallenangel.security.model.entity.Role;
import top.fallenangel.security.service.IRoleService;

import java.util.List;

@Service
public class RoleService implements IRoleService
{
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleAuthMapper roleAuthMapper;

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
