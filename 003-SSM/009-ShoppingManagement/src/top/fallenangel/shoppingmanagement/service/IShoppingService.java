package top.fallenangel.shoppingmanagement.service;

import top.fallenangel.shoppingmanagement.model.entity.Shopping;

import java.util.List;

public interface IShoppingService {
    int save(Shopping shopping);

    int delete(int[] id);

    int update(Shopping shopping);

    Shopping get(int id);

    List<Shopping> list();
}