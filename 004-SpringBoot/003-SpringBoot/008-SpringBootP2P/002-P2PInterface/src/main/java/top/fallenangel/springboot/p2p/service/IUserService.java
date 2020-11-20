package top.fallenangel.springboot.p2p.service;

import top.fallenangel.springboot.p2p.model.entity.User;

public interface IUserService {
    /**
     * 查询平台用户数
     *
     * @return 平台用户数
     */
    int queryTotalUser();

    /**
     * 查询手机号的数量
     *
     * @param phone 手机号
     * @return 手机号数量
     */
    int queryPhoneNum(String phone);

    /**
     * 在用户表中新增用户，同时赠送888大礼包
     *
     * @param phone 手机号
     * @param pwd   密码
     * @return 注册成功后的用户
     */
    User register(String phone, String pwd);

    /**
     * 用户登录
     *
     * @param phone 手机号
     * @param pwd   密码
     * @return 登录后的用户
     */
    User login(String phone, String pwd);

    /**
     * 修改用户信息
     *
     * @param user 用户
     */
    void modify(User user);
}
