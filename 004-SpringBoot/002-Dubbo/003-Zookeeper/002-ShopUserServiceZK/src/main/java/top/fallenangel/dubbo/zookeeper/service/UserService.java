package top.fallenangel.dubbo.zookeeper.service;

import top.fallenangel.dubbo.zookeeper.entity.Address;

import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {
    @Override
    public List<Address> listUserAddress() {
        List<Address> addresses = new ArrayList<>();

        addresses.add(new Address(1, "张三", "北京", "房山"));
        addresses.add(new Address(1, "李四", "北京", "丰台"));
        addresses.add(new Address(1, "王五", "北京", "通州"));

        return addresses;
    }
}