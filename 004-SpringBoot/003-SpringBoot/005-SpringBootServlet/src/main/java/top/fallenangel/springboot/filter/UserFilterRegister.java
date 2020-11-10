package top.fallenangel.springboot.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserFilterRegister {
    @Bean(name = "filter")
    public FilterRegistrationBean<UserFilter> userFilterRegister() {
        FilterRegistrationBean<UserFilter> userFilterRegistration = new FilterRegistrationBean<>(new UserFilter());

        userFilterRegistration.addUrlPatterns("/*");

        return userFilterRegistration;
    }
}
