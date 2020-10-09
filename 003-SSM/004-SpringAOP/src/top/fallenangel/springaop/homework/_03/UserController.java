package top.fallenangel.springaop.homework._03;

import org.springframework.stereotype.Component;

@Component
public class UserController {
    public void buyTicket() {
        System.out.println("买票中...");
    }
}