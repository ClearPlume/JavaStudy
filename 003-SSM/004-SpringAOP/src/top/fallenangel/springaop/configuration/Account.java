package top.fallenangel.springaop.configuration;

public class Account implements IAccount {
    public int out() {
        System.out.println("已扣除金额");
        // int i = 10 / 0;
        return 100;
    }
}