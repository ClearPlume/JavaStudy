package top.fallenangel.shoppingmanagement.model.dao;

import top.fallenangel.shoppingmanagement.model.entity.Shopping;

import java.util.List;

public interface IShoppingDao {
    int insert(Shopping record);

    int insertSelective(Shopping record);

    int deleteByPrimaryKey(int[] shoppingId);

    int updateByPrimaryKeySelective(Shopping record);

    int updateByPrimaryKey(Shopping record);

    Shopping selectByPrimaryKey(Integer shoppingId);

    List<Shopping> selectAll();
}