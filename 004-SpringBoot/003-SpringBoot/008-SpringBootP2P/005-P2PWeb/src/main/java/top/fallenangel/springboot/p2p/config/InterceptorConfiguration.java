package top.fallenangel.springboot.p2p.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.fallenangel.springboot.p2p.interceptor.LoginInterceptor;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 配置登录过滤器
        String[] excludePaths = {
                "/", "/loan/logout", "/loan/page/loginSubmit", "/loan/page/login", "/loan/page/checkNum",
                "/loan/page/registerSubmit", "/loan/page/checkPhoneAvailable", "/loan/page/register", "/**/*.css",
                "/**/*.jpg", "/**/*.js", "/**/*.png"
        };
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(excludePaths);

    }
}
