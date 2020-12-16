package top.fallenangel.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.fallenangel.security.model.dao.UserAuthMapper;
import top.fallenangel.security.service.IUserAuthService;

@Service
public class UserAuthService implements IUserAuthService
{
    @Autowired
    private UserAuthMapper userAuthMapper;

    @Override
    @Transactional
    public void update(int userId, int[] authIds)
    {
        //删除旧权限
        userAuthMapper.deleteByUser(userId);

        //保存新权限
        if (authIds != null && authIds.length > 0)
        {
            userAuthMapper.insertBatch(userId, authIds);
        }
    }
}
