package top.fallenangel.springaop.homework._01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserLoginTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("homework_conf/homework01.xml");
        UserController userController = xmlApplicationContext.getBean(UserController.class);
        userController.login();
    }
}