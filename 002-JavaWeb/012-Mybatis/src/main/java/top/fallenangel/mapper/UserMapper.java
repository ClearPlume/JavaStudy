package top.fallenangel.mapper;

import org.apache.ibatis.annotations.Param;
import top.fallenangel.bean.User;

public interface UserMapper {
    /**
     * 使用名字和字码登录
     *
     * @param name 名字
     * @param pwd  密码
     * @return 登录成功则返回用户，否则返回null
     */
    User login(@Param("name") String name, @Param("pwd") String pwd);

    /**
     * 使用名字查询用户
     *
     * @param name 名字
     * @return 查询成功则返回用户，否则返回null
     */
    User query(String name);
}
