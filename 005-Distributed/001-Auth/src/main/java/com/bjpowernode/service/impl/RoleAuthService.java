package com.bjpowernode.service.impl;

import com.bjpowernode.model.dao.RoleAuthMapper;
import com.bjpowernode.model.entity.RoleAuth;
import com.bjpowernode.service.IRoleAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleAuthService implements IRoleAuthService {
    @Autowired
    RoleAuthMapper roleAuthMapper;

    public List<RoleAuth> list(int roleId){
        return roleAuthMapper.selectByRole(roleId);
    }

    @Override
    @Transactional
    public void save(int roleId, List<Integer> authIds) {
        // 这是一对多的关系，一个角色对应多个权限。因此直接删除这个角色的全部权限，再重新插入
        roleAuthMapper.deleteByRole(roleId);

        roleAuthMapper.insertBatch(roleId, authIds);
    }
}
