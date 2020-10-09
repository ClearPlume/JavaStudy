package top.fallenangel.springaop.homework._06;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServletHelper {
    @Pointcut("execution(public void top.fallenangel.springaop.homework._06.*.*(..))")
    public void pointcut() {}

    @Before("pointcut()")
    public void openTransaction() {
        System.out.println("开启事务");
    }

    @After("pointcut()")
    public void closeTransaction() {
        System.out.println("关闭事务");
    }
}