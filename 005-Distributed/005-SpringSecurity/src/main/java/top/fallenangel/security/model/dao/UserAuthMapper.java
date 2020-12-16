package top.fallenangel.security.model.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.fallenangel.security.model.entity.UserAuth;

@Repository
public interface UserAuthMapper {
    int deleteByPrimaryKey(Integer userAuthId);

    int deleteByUser(Integer userId);

    int insert(UserAuth record);

    int insertBatch(@Param("userId") int userId, @Param("authIds") int[] authIds);

    int insertSelective(UserAuth record);

    UserAuth selectByPrimaryKey(Integer userAuthId);

    int updateByPrimaryKeySelective(UserAuth record);

    int updateByPrimaryKey(UserAuth record);
}
