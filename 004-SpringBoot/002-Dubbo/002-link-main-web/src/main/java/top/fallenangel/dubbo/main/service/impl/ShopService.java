package top.fallenangel.dubbo.main.service.impl;

import top.fallenangel.dubbo.main.service.IShopService;
import top.fallenangel.dubbo.order.entity.Order;
import top.fallenangel.dubbo.order.service.IOrderService;

public class ShopService implements IShopService {
    private IOrderService orderService;

    @Override
    public Order buyGoods(Integer userID, String goodsName, Double price, Integer amount) {
        return orderService.addOrder(userID, goodsName, price, amount);
    }

    public void setOrderService(IOrderService orderService) {
        this.orderService = orderService;
    }
}