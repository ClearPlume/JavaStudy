package top.fallenangel.springaop.homework._02;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserControllerHelper {
    @After("execution(public void top.fallenangel.springaop.homework._02.UserController.buy())")
    public void sendEmail() {
        System.out.println("购买成功邮件已发送");
    }
}