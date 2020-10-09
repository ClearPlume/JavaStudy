package top.fallenangel.springtransaction;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.fallenangel.springtransaction.controller.AccountController;

public class SpringTransactionTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        AccountController accountController = xmlApplicationContext.getBean(AccountController.class);
        accountController.transfer("张三", "李四", 1000);
    }
}