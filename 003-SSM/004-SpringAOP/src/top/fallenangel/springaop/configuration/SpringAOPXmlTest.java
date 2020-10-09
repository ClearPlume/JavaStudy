package top.fallenangel.springaop.configuration;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAOPXmlTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        IAccount account = (IAccount) xmlApplicationContext.getBean("account");
        account.out();
    }
}