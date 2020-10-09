package top.fallenangel.aop.statics.extend;

public class StaticProxyTest {
    public static void main(String[] args) {
        Account account = new StaticsProxyAccount();
        account.out();
    }
}