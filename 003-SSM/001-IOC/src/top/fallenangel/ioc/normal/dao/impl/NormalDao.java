package top.fallenangel.ioc.normal.dao.impl;

import top.fallenangel.ioc.normal.dao.INormalDao;

public class NormalDao implements INormalDao {
    @Override
    public void insert() {
        System.out.println("数据保存成功");
    }
}