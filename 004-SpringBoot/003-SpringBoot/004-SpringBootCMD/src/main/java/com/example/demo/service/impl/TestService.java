package com.example.demo.service.impl;

import com.example.demo.service.ITestService;
import org.springframework.stereotype.Service;

@Service
public class TestService implements ITestService {
    @Override
    public String say(String name) {
        return "Hi, I'm " + name;
    }
}
