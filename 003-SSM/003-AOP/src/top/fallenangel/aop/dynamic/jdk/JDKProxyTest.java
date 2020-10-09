package top.fallenangel.aop.dynamic.jdk;

public class JDKProxyTest {
    public static void main(String[] args) {
        IAccount account = JDKProxyFactory.createProxy(IAccount.class, Account.class, new JDKProxyFactory.ProxyNotice() {
            @Override
            public void before() {
                System.out.println("验证账户和密码是否匹配");
                System.out.println("检查账户余额是否足够");
            }

            @Override
            public void after() {
                System.out.println("生成对账单");
                System.out.println("将对账单发往上级银行");
                System.out.println("给用户发送短信");
            }
        });
        account.out();
    }
}