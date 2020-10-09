package top.fallenangel.flower;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.fallenangel.flower.controller.UserServlet;

public class IOCTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        UserServlet userServlet = xmlApplicationContext.getBean(UserServlet.class);

        userServlet.insert();
        System.out.println(userServlet.getName() + "：" + userServlet.getAge());

        xmlApplicationContext.registerShutdownHook();
    }
}