package top.fallenangel.flower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import top.fallenangel.flower.service.IUserService;

@Controller
public class UserServlet {
    private final IUserService userService;

    @Value("${name}")
    private String name;

    @Value("${age}")
    private int age;

    @Autowired
    public UserServlet(IUserService userService) {
        this.userService = userService;
    }

    public void insert() {
        userService.insert();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}