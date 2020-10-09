package top.fallenangel.springaop.homework._03;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Aspect
public class UserControllerHelper {
    @Before("execution(public void top.fallenangel.springaop.homework._03.UserController.buyTicket())")
    public void checkBuy() {
        System.out.println(new Random().nextBoolean() ? "买过了" : "没买过");
    }

    @After("execution(public void top.fallenangel.springaop.homework._03.UserController.buyTicket())")
    public void sendWechat() {
        System.out.println("发送微信消息...");
    }
}