package top.fallenangel.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan({"top.fallenangel.springboot.servlet", "top.fallenangel.springboot.filter"})
public class SpringBootServletApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootServletApplication.class, args);
    }
}
