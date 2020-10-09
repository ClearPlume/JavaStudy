package top.fallenangel.aop.statics.implement;

public class DynamicProxyTest {
    public static void main(String[] args) {
        IAccount account = new DynamicProxyAccount();
        account.out();
    }
}