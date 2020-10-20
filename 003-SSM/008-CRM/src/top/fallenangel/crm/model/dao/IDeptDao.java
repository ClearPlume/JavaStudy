package top.fallenangel.crm.model.dao;

import top.fallenangel.crm.model.entity.Dept;

import java.util.List;

public interface IDeptDao {
    int deleteByPrimaryKey(Integer deptId);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer deptId);

    List<Dept> selectAll();

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}