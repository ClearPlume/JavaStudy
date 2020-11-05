package top.fallenangel.dubbo.zookeeper.service;

import top.fallenangel.dubbo.zookeeper.entity.Order;

import java.util.UUID;

public class OrderService implements IOrderService {
    @Override
    public Order addOrder(Integer userId, String goodsName, Double price, Integer amount) {
        return new Order(UUID.randomUUID().toString(), goodsName, price, amount);
    }
}