package top.fallenangel.dubbo.order.service;

import top.fallenangel.dubbo.order.entity.Order;

public interface IOrderService {
    Order addOrder(Integer userId, String goodsName, Double price, Integer amount);
}