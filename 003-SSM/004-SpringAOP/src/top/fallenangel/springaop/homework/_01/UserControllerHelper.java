package top.fallenangel.springaop.homework._01;

import java.util.Random;

public class UserControllerHelper {
    public void checkLogin() {
        if (new Random().nextBoolean()) {
            System.out.println("已登录，欢迎！");
        } else {
            System.out.println("未登录，登录中...");
        }
    }
}