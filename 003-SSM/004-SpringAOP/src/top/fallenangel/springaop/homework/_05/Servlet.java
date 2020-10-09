package top.fallenangel.springaop.homework._05;

import org.springframework.stereotype.Component;

@Component
public class Servlet {
    public void service() {
        System.out.println("调用模型层...");
    }
}