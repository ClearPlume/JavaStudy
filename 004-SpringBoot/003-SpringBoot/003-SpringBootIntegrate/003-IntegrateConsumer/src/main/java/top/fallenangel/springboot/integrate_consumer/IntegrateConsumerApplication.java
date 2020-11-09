package top.fallenangel.springboot.integrate_consumer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class IntegrateConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntegrateConsumerApplication.class, args);
    }

}
