package com.bjpowernode.model.service;

import com.bjpowernode.entity.Auth;
import com.bjpowernode.model.dao.AuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService implements IAuthService {
    @Autowired
    AuthMapper authMapper;

    @Override
    public List<Auth> list() {
        return authMapper.selectAll();
    }

    @Override
    public List<Integer> listByUser(int userId) {
        return authMapper.selectByUser(userId);
    }

    @Override
    public List<Auth> listByRole(int roleId) {
        return authMapper.selectByRole(roleId);
    }

    @Override
    public Auth get(int authId) {
        return authMapper.selectByPrimaryKey(authId);
    }

    @Override
    public void save(Auth auth) {
        authMapper.insert(auth);
    }

    @Override
    public void update(Auth auth) {
        authMapper.updateByPrimaryKey(auth);
    }

    @Override
    public void delete(int[] authId) {
        authMapper.deleteByPrimaryKey(authId);
    }
}
