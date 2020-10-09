package top.fallenangel.springaop.homework._02;

import org.springframework.stereotype.Component;

@Component
public class UserController {
    public void buy() {
        System.out.println("买东西了");
    }
}