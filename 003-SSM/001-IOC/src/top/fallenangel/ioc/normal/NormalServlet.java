package top.fallenangel.ioc.normal;

import top.fallenangel.ioc.normal.service.INormalService;
import top.fallenangel.ioc.normal.service.impl.NormalService;

public class NormalServlet {

    public static void main(String[] args) {
        INormalService normalService = new NormalService();
        normalService.insert();
    }
}