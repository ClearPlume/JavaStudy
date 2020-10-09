package top.fallenangel.springaop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AccountHelper {
    @Pointcut("execution(public int top.fallenangel.springaop.annotation.Account.out())")
    public void accountPoint() { }

    @Before("accountPoint()")
    public void validAuth() {
        System.out.println("验证账户是否合法");
    }

    @Before("accountPoint()")
    public void validAmount() {
        System.out.println("检查余额是否足够");
    }

    @After("accountPoint()")
    public void generateStatement() {
        System.out.println("生成对账单");
    }

    @After("accountPoint()")
    public void sendMsg() {
        System.out.println("发送短信");
    }

    // @Around("accountPoint()")
    public int aroundOut(ProceedingJoinPoint joinPoint) throws Throwable {
        validAuth();
        validAmount();
        int proceed = (int) joinPoint.proceed();
        generateStatement();
        sendMsg();

        return proceed;
    }

    @AfterReturning(pointcut = "accountPoint()", returning = "amount")
    public int getResult(int amount) {
        System.out.println("amount = " + amount);
        return amount;
    }

    @AfterThrowing("accountPoint()")
    public void exception() {
        System.out.println("异常发生");
    }
}