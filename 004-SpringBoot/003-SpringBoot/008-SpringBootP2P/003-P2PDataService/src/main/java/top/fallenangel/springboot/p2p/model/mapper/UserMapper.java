package top.fallenangel.springboot.p2p.model.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.fallenangel.springboot.p2p.model.entity.User;

@Repository
public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByPrimaryKey(Integer id);

    /**
     * 查询平台用户数
     *
     * @return 平台用户数
     */
    int count();

    /**
     * 查询手机号的数量
     *
     * @param phone 手机号
     * @return 手机号数量
     */
    int selectPhoneCount(@Param("phone") String phone);

    /**
     * 用户登录
     *
     * @param phone 手机号
     * @param pwd   密码
     * @return 登录后的用户
     */
    User selectByPhonePwd(@Param("phone") String phone, @Param("pwd") String pwd);
}