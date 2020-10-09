package top.fallenangel.springaop.configuration;

import org.aspectj.lang.ProceedingJoinPoint;

public class AccountHelper {
    public void validAuth() {
        System.out.println("验证账户是否合法");
    }

    public void validAmount() {
        System.out.println("检查余额是否足够");
    }

    public void generateStatement() {
        System.out.println("生成对账单");
    }

    public void sendMsg() {
        System.out.println("发送短信");
    }

    public int aroundOut(ProceedingJoinPoint joinPoint) throws Throwable {
        validAuth();
        validAmount();
        int proceed = (int) joinPoint.proceed();
        generateStatement();
        sendMsg();
        return proceed;
    }

    public int getResult(int amount) {
        System.out.println("amount = " + amount);
        return amount;
    }

    public void exception() {
        System.out.println("异常发生");
    }
}