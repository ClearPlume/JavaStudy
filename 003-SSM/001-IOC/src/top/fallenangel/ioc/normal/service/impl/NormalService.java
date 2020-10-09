package top.fallenangel.ioc.normal.service.impl;

import top.fallenangel.ioc.normal.dao.INormalDao;
import top.fallenangel.ioc.normal.dao.impl.NormalDao;
import top.fallenangel.ioc.normal.service.INormalService;

public class NormalService implements INormalService {
    private final INormalDao normalDao = new NormalDao();

    @Override
    public void insert() {
        normalDao.insert();
    }
}