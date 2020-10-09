package top.fallenangel.springaop.homework._02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserBuyTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("homework_conf/homework02.xml");
        UserController userController = xmlApplicationContext.getBean(UserController.class);
        userController.buy();
    }
}