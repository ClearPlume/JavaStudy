package com.bjpowernode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Hello world!
 */
@SpringBootApplication
@MapperScan(basePackages = "com.bjpowernode.model.dao") //dao接口所在的目录
//@ServletComponentScan
//@ImportResource("spring-shiro.xml")
public class AuthApp extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(AuthApp.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AuthApp.class);
    }
}
