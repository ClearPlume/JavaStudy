package top.fallenangel.springaop.homework._03;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserBuyTicketTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("homework_conf/homework03.xml");
        UserController userController = xmlApplicationContext.getBean(UserController.class);
        userController.buyTicket();
    }
}