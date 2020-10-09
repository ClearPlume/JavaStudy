package top.fallenangel.springaop.annotation;

import org.springframework.stereotype.Component;

@Component
public class Account {
    public int out() {
        System.out.println("已扣除金额");
        // int i = 10 / 0;
        return 100;
    }
}