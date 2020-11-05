package top.fallenangel.dubbo.improve.service;

import top.fallenangel.dubbo.improve.entity.Address;
import top.fallenangel.dubbo.improve.entity.Goods;
import top.fallenangel.dubbo.improve.entity.Order;

import java.util.List;

public interface IShopService {
    Order createOrder(Integer userId, Goods goods);

    List<Address> showAddress();
}