package top.fallenangel.security.model.dao;

import org.springframework.stereotype.Repository;
import top.fallenangel.security.model.entity.Role;

import java.util.List;

@Repository
public interface RoleMapper {
    int deleteByPrimaryKey(int[] roleId);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer roleId);

    List<Role> selectAll();

    List<Role> listByUser(Integer userId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}
