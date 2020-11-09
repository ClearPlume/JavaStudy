package top.fallenangel.springboot.integrate_provider;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
@MapperScan(basePackages = "top.fallenangel.springboot.integrate_provider.model.mapper")
public class IntegrateProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntegrateProviderApplication.class, args);
    }

}
