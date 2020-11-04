package top.fallenangel.dubbo.order.service.impl;

import top.fallenangel.dubbo.order.entity.Order;
import top.fallenangel.dubbo.order.service.IOrderService;

import java.util.UUID;

public class OrderService implements IOrderService {
    @Override
    public Order addOrder(Integer userId, String goodsName, Double price, Integer amount) {
        Order order = new Order();

        order.setId(UUID.randomUUID().toString());
        order.setName(goodsName);
        order.setPrice(price);
        order.setAmount(amount);

        return order;
    }
}