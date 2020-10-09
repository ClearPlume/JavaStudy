package top.fallenangel.springaop.homework._04;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PageTurnTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext xmlApplicationContext = new ClassPathXmlApplicationContext("homework_conf/homework04.xml");
        PageTurn pageTurn = xmlApplicationContext.getBean(PageTurn.class);
        pageTurn.turn();
    }
}