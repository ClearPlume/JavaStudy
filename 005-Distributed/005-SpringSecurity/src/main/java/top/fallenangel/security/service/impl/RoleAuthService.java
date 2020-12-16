package top.fallenangel.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.fallenangel.security.model.dao.RoleAuthMapper;
import top.fallenangel.security.model.entity.RoleAuth;
import top.fallenangel.security.service.IRoleAuthService;

import java.util.List;

@Service
public class RoleAuthService implements IRoleAuthService
{
    @Autowired
    private RoleAuthMapper roleAuthMapper;

    public List<RoleAuth> list(int roleId)
    {
        return roleAuthMapper.selectByRole(roleId);
    }

    @Override
    @Transactional
    public void save(int roleId, List<Integer> authIds)
    {
        // 这是一对多的关系，一个角色对应多个权限。因此直接删除这个角色的全部权限，再重新插入
        roleAuthMapper.deleteByRole(roleId);

        roleAuthMapper.insertBatch(roleId, authIds);
    }
}
