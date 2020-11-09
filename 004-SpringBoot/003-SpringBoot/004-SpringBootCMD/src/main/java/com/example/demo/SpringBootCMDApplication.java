package com.example.demo;

import com.example.demo.service.ITestService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootCMDApplication implements CommandLineRunner {
    private final ITestService testService;

    public SpringBootCMDApplication(ITestService testService) {
        this.testService = testService;
    }

    /**
     * SpringBoot运行纯Java程序两种方法：
     *   1、入口主程序实现CommandLineRunner接口，重写run方法；需要的bean由Spring注入
     *
     *   2、在main方法中执行的SpringApplication.run()方法，会返回一个Spring容器
     */
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootCMDApplication.class, args);
        ITestService testService = applicationContext.getBean(ITestService.class);
        System.out.println("testService.say(\"刘四爷\") = " + testService.say("刘四爷"));
    }

    @Override
    public void run(String... args) {
        System.out.println("testService.say(\"张三丰\") = " + testService.say("张三丰"));
    }
}
