package top.fallenangel.security.service;

import top.fallenangel.security.model.entity.User;

import java.util.List;

public interface IUserService
{

    List<User> list();

    User login(User user);

    User get(int userId);

    void save(User user);

    void update(User user);

    void delete(int[] userId);

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 数据库中的用户。不存在名为“username”的用户则返回null
     */
    User get(String username);

    /**
     * 根据用户id查询用户所有的权限Code
     *
     * @param userId 用户id
     * @return 权限Code列表
     */
    List<String> listAuthCode(int userId);
}
