package top.fallenangel.dubbo.zookeeper.service;

import top.fallenangel.dubbo.zookeeper.entity.Address;

import java.util.List;

public interface IUserService {
    List<Address> listUserAddress();
}