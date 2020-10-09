package top.fallenangel.spring.mvc.model.dao;

import top.fallenangel.spring.mvc.entity.Area;

import java.util.List;

public interface IAreaDao {
    int deleteByPrimaryKey(Integer areaId);

    void deleteAll(Integer[] areaId);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer areaId);

    List<Area> selectAll();

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
}