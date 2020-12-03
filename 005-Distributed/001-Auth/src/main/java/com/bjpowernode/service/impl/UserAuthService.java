package com.bjpowernode.service.impl;

import com.bjpowernode.model.dao.UserAuthMapper;
import com.bjpowernode.service.IUserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserAuthService implements IUserAuthService {
    @Autowired
    UserAuthMapper userAuthMapper;

    @Override
    @Transactional
    public void update(int userId, int[] authIds) {
        //删除旧权限
        userAuthMapper.deleteByUser(userId);

        //保存新权限
        if (authIds != null && authIds.length > 0) {
            userAuthMapper.insertBatch(userId, authIds);
        }
    }
}
