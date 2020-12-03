package com.bjpowernode.service.impl;

import com.bjpowernode.model.dao.RoleAuthMapper;
import com.bjpowernode.model.dao.RoleMapper;
import com.bjpowernode.model.entity.Role;
import com.bjpowernode.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService implements IRoleService {
    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RoleAuthMapper roleAuthMapper;

    @Override
    public List<Role> list() {
        return roleMapper.selectAll();
    }

    @Override
    public List<Role> listByUser(int userId) {
        return roleMapper.listByUser(userId);
    }

    @Override
    public Role get(int roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public void save(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public void update(Role role) {
        roleMapper.updateByPrimaryKey(role);
    }

    @Override
    @Transactional
    public void delete(int[] roleId) {
        roleAuthMapper.deleteByRoleBatch(roleId);
        roleMapper.deleteByPrimaryKey(roleId);
    }
}
