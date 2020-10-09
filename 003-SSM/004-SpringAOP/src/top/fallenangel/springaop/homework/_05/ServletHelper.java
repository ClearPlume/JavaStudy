package top.fallenangel.springaop.homework._05;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServletHelper {
    @Pointcut("execution(public void top.fallenangel.springaop.homework._05.Servlet.service())")
    public void pointcut() {}

    @Before("pointcut()")
    public void getParam() {
        System.out.println("获取参数...");
    }

    @After("pointcut()")
    public void save2Request() {
        System.out.println("存入Request...");
    }

    @After("pointcut()")
    public void sendResponse() {
        System.out.println("给用户反馈");
    }
}