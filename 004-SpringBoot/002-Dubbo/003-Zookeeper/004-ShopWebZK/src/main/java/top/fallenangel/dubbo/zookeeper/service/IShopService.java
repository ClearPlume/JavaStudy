package top.fallenangel.dubbo.zookeeper.service;

import top.fallenangel.dubbo.zookeeper.entity.Address;
import top.fallenangel.dubbo.zookeeper.entity.Goods;
import top.fallenangel.dubbo.zookeeper.entity.Order;

import java.util.List;

public interface IShopService {
    Order createOrder(Integer userId, Goods goods);

    List<Address> showAddress();
}