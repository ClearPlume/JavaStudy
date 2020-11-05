package top.fallenangel.dubbo.zookeeper.service.impl;

import top.fallenangel.dubbo.zookeeper.entity.Address;
import top.fallenangel.dubbo.zookeeper.entity.Goods;
import top.fallenangel.dubbo.zookeeper.entity.Order;
import top.fallenangel.dubbo.zookeeper.service.IOrderService;
import top.fallenangel.dubbo.zookeeper.service.IShopService;
import top.fallenangel.dubbo.zookeeper.service.IUserService;

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