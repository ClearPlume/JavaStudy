package top.fallenangel.springboot.p2p;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableDubboConfiguration
public class P2PTimerTaskApplication {
	public static void main(String[] args) {
		SpringApplication.run(P2PTimerTaskApplication.class, args);
	}
}
