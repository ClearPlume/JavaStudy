package top.fallenangel.ioc.ioc.dao.impl;

import top.fallenangel.ioc.ioc.dao.IIOCDao;

public class IOCDao implements IIOCDao {
    @Override
    public void insert() {
        System.out.println("数据保存");
    }
}