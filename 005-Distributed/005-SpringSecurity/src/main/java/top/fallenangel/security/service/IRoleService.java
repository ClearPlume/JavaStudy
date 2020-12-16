package top.fallenangel.security.service;

import top.fallenangel.security.model.entity.Role;

import java.util.List;

public interface IRoleService {

    List<Role> list();

    Role get(int roleId);

    List<Role> listByUser(int userId);

    void save(Role role);

    void update(Role role);

    void delete(int[] roleId);
}
