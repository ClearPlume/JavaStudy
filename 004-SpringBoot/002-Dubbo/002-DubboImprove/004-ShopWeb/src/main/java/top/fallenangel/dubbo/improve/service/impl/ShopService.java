package top.fallenangel.dubbo.improve.service.impl;

import top.fallenangel.dubbo.improve.entity.Address;
import top.fallenangel.dubbo.improve.entity.Goods;
import top.fallenangel.dubbo.improve.entity.Order;
import top.fallenangel.dubbo.improve.service.IOrderService;
import top.fallenangel.dubbo.improve.service.IShopService;
import top.fallenangel.dubbo.improve.service.IUserService;

import java.util.List;

public class ShopService implements IShopService {
    private IOrderService orderService;
    private IUserService userService;

    public void setOrderService(IOrderService orderService) {
        this.orderService = orderService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public Order createOrder(Integer userId, Goods goods) {
        return orderService.addOrder(userId, goods.getName(), goods.getPrice(), goods.getAmount());
    }

    @Override
    public List<Address> showAddress() {
        return userService.listUserAddress();
    }
}