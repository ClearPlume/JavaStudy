package top.fallenangel.aop.dynamic.jdk;

public class Account implements IAccount {
    public void out() {
        System.out.println("已扣除金额");
    }
}