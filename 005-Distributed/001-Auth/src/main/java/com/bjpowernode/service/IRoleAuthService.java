package com.bjpowernode.service;

import com.bjpowernode.model.entity.RoleAuth;

import java.util.List;

public interface IRoleAuthService {

    List<RoleAuth> list(int roleId);

    void save(int roleId, List<Integer> authIds);

}
