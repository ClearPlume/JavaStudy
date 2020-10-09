package top.fallenangel.aop.statics.extend;

public class StaticsProxyAccount extends Account {
    @Override
    public void out() {
        System.out.println("验证账户和密码是否匹配");
        System.out.println("检查账户余额是否足够");
        super.out();//调用真实目标（被代理者）
        System.out.println("生成对账单");
        System.out.println("将对账单发往上级银行");
        System.out.println("给用户发送短信");
    }
}