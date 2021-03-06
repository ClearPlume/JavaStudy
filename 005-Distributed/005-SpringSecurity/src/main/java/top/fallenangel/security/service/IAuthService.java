package top.fallenangel.security.service;

import top.fallenangel.security.model.entity.Auth;

import java.util.List;

public interface IAuthService {

    List<Auth> list();

    List<Integer> listByUser(int userId);

    List<Auth> listByRole(int roleId);

    Auth get(int userId);

    void save(Auth auth);

    void update(Auth auth);

    void delete(int[] userId);
}
