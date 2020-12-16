package top.fallenangel.security.model.dao;

import org.springframework.stereotype.Repository;
import top.fallenangel.security.model.entity.Auth;

import java.util.List;

@Repository
public interface AuthMapper {

    int deleteByPrimaryKey(int[] authId);

    int insert(Auth record);

    int insertSelective(Auth record);

    Auth selectByPrimaryKey(Integer authId);

    List<Auth> selectAll();

    /**
     * 用户拥有的权限id
     *
     * @param userId 用户id
     */
    List<Integer> selectByUser(int userId);

    List<Auth> selectByRole(int roleId);

    int updateByPrimaryKeySelective(Auth record);

    int updateByPrimaryKey(Auth record);
}