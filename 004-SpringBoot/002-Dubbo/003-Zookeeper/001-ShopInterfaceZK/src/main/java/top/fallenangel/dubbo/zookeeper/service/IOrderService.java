package top.fallenangel.dubbo.zookeeper.service;

import top.fallenangel.dubbo.zookeeper.entity.Order;

public interface IOrderService {
    Order addOrder(Integer userId, String goodsName, Double price, Integer amount);
}