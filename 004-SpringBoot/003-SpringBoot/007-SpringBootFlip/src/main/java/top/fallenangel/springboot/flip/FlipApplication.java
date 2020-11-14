package top.fallenangel.springboot.flip;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("top.fallenangel.springboot.flip.model.mapper")
public class FlipApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(FlipApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(FlipApplication.class);
	}
}
