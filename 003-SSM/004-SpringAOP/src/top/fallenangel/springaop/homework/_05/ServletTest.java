package top.fallenangel.springaop.homework._05;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServletTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("homework_conf/homework05.xml");
        Servlet servlet = xmlApplicationContext.getBean(Servlet.class);
        servlet.service();
    }
}