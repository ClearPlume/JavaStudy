package top.fallenangel.springmybatis.model.dao;

import top.fallenangel.springmybatis.model.bean.Flower;
import top.fallenangel.springmybatis.model.bean.FlowerVO;

import java.util.List;

public interface IFlowerDao {
    int insert(Flower record);

    int insertSelective(Flower record);

    int deleteByPrimaryKey(Integer fId);

    int updateByPrimaryKeySelective(Flower record);

    int updateByPrimaryKey(Flower record);

    Flower selectByPrimaryKey(Integer fId);

    List<Flower> selectAllSelective(FlowerVO flowerVO);

    List<Flower> selectAll();
}