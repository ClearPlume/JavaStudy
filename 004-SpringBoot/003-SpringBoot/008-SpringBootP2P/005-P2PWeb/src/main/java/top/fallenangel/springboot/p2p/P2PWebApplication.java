package top.fallenangel.springboot.p2p;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class P2PWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(P2PWebApplication.class, args);
	}
}
