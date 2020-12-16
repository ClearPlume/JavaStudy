package top.fallenangel.security.model.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.fallenangel.security.model.entity.UserRole;

@Repository
public interface UserRoleMapper {

    int deleteByPrimaryKey(Integer userRoleId);

    int deleteByUser(int userId);

    int insert(UserRole record);

    int insertBatch(@Param("userId") int userId, @Param("roleIds") int[] roleIds);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer userRoleId);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}