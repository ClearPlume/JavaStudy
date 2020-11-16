package top.fallenangel.springboot.p2p.model.mapper;

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

    int count();
}