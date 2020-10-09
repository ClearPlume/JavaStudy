package top.fallenangel.springaop.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAOPAnnoTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("spring-anno.xml");
        Account account = (Account) xmlApplicationContext.getBean("account");
        account.out();
    }
}