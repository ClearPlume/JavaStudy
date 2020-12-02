package com.bjpowernode.model.service;

import com.bjpowernode.entity.RoleAuth;

import java.util.List;

public interface IRoleAuthService {

    List<RoleAuth> list(int roleId);

    void save(int roleId, List<Integer> authIds);

}
