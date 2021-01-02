package top.fallenangel.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(@NonNull InterceptorRegistry registry) {
        // registry.addInterceptor(new LoginInterceptor())
        //         .addPathPatterns("/**")
        //         .excludePathPatterns("/login", "/saveLogin", "/error", "/**/css/**", "/**/imgs/**", "/**/js/**");
    }
}
