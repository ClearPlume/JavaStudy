package top.fallenangel.security.model.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.fallenangel.security.model.entity.RoleAuth;

import java.util.List;

@Repository
public interface RoleAuthMapper {
    int insert(RoleAuth record);

    int insertSelective(RoleAuth record);

    /**
     * 批量插入角色权限信息
     *
     * @param roleId  角色id
     * @param authIds 角色权限
     */
    void insertBatch(@Param("roleId") int roleId, @Param("authIds") List<Integer> authIds);

    int deleteByPrimaryKey(Integer roleAuthId);

    /**
     * 删除某角色的权限
     *
     * @param roleId 角色id
     */
    int deleteByRole(Integer roleId);

    /**
     * 批量插入角色权限
     *
     * @param roleId 角色id
     */
    void deleteByRoleBatch(int[] roleId);

    int updateByPrimaryKeySelective(RoleAuth record);

    int updateByPrimaryKey(RoleAuth record);

    RoleAuth selectByPrimaryKey(Integer roleAuthId);

    List<RoleAuth> selectByRole(Integer roleId);
}
