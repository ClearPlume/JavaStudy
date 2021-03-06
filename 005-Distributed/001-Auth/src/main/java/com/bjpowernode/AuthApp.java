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
@MapperScan("com.bjpowernode.model.dao")
// @ImportResource("classpath:spring-shiro.xml")
public class AuthApp extends SpringBootServletInitializer
{
    public static void main(String[] args)
    {
        SpringApplication.run(AuthApp.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
    {
        return builder.sources(AuthApp.class);
    }
}
