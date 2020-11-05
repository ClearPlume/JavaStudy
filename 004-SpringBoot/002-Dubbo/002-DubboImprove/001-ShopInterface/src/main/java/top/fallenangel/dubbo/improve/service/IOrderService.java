package top.fallenangel.dubbo.improve.service;

import top.fallenangel.dubbo.improve.entity.Order;

public interface IOrderService {
    Order addOrder(Integer userId, String goodsName, Double price, Integer amount);
}