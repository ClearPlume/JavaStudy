package top.fallenangel.springboot.flip;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("top.fallenangel.springboot.flip.model.mapper")
public class FlipApplication {
	public static void main(String[] args) {
		SpringApplication.run(FlipApplication.class, args);
	}
}
