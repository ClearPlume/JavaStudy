package top.fallenangel.spring.mvc.model.dao;

import top.fallenangel.spring.mvc.entity.Dept;

import java.util.List;

public interface IDeptDao {
    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer deptId);

    List<Dept> selectAll();

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    int deleteAll(Integer[] deptId);

    int deleteByPrimaryKey(Integer deptId);

    int count();
}