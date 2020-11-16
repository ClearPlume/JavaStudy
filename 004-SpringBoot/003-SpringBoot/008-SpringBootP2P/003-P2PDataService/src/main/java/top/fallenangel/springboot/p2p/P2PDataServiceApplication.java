package top.fallenangel.springboot.p2p;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
@MapperScan("top.fallenangel.springboot.p2p.model.mapper")
public class P2PDataServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(P2PDataServiceApplication.class, args);
	}
}
