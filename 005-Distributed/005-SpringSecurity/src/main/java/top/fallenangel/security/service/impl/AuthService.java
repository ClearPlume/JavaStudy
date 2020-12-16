package top.fallenangel.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.fallenangel.security.model.dao.AuthMapper;
import top.fallenangel.security.model.entity.Auth;
import top.fallenangel.security.service.IAuthService;

import java.util.List;

@Service
public class AuthService implements IAuthService
{
    @Autowired
    private AuthMapper authMapper;

    @Override
    public List<Auth> list()
    {
        return authMapper.selectAll();
    }

    @Override
    public List<Integer> listByUser(int userId)
    {
        return authMapper.selectByUser(userId);
    }

    @Override
    public List<Auth> listByRole(int roleId)
    {
        return authMapper.selectByRole(roleId);
    }

    @Override
    public Auth get(int authId)
    {
        return authMapper.selectByPrimaryKey(authId);
    }

    @Override
    public void save(Auth auth)
    {
        authMapper.insert(auth);
    }

    @Override
    public void update(Auth auth)
    {
        authMapper.updateByPrimaryKey(auth);
    }

    @Override
    public void delete(int[] authId)
    {
        authMapper.deleteByPrimaryKey(authId);
    }
}
