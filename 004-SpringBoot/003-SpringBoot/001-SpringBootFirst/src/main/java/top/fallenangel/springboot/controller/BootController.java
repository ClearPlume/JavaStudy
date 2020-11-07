package top.fallenangel.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fallenangel.springboot.component.Test;

@RestController
public class BootController {
    private final Test test;

    public BootController(Test test) {
        this.test = test;
    }

    @GetMapping("say")
    public String say() {
        return "Hello, " + test.toString();
    }

    @PostMapping("hello")
    public String hello(String name) {
        return "hello, " + name;
    }
}