package com.bjpowernode.model.dao;

import com.bjpowernode.model.entity.UserAuth;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
