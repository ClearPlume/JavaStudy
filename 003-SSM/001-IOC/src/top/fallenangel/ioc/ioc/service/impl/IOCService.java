package top.fallenangel.ioc.ioc.service.impl;

import top.fallenangel.ioc.ioc.dao.IIOCDao;
import top.fallenangel.ioc.ioc.service.IIOCService;

public class IOCService implements IIOCService {
    private IIOCDao iocDao;

    public void setIocDao(IIOCDao iocDao) {
        this.iocDao = iocDao;
    }

    @Override
    public void insert() {
        iocDao.insert();
    }
}