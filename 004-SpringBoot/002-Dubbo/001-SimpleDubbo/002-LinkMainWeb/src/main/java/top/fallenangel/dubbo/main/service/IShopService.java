package top.fallenangel.dubbo.main.service;

import top.fallenangel.dubbo.order.entity.Order;

public interface IShopService {
    Order buyGoods(Integer userID, String goodsName, Double price, Integer amount);
}