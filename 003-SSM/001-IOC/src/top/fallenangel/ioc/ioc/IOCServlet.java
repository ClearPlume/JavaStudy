package top.fallenangel.ioc.ioc;

import top.fallenangel.ioc.ioc.dao.impl.IOCDao;
import top.fallenangel.ioc.ioc.service.impl.IOCService;

public class IOCServlet {
    public static void main(String[] args) {
        IOCService iocService = new IOCService();
        iocService.setIocDao(new IOCDao());
        iocService.insert();
    }
}