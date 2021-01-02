package top.fallenangel.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PersistentTokenRepository persistentTokenRepository;

    @Autowired
    @Qualifier("userDetailServiceImpl")
    private UserDetailsService userDetails;

    @Bean
    public PasswordEncoder createPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository createPersistentTokenRepository() {

        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();

        // 初次运行时，需要启动时自动创建表
        // tokenRepository.setCreateTableOnStartup(true);
        tokenRepository.setDataSource(dataSource);

        return tokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 表单登录
        http.formLogin()
                .loginPage("/login")
                .usernameParameter("userName")
                .passwordParameter("userPwd")
                .loginProcessingUrl("/saveLogin")
                .successForwardUrl("/")
                .failureForwardUrl("/login");

        // 退出登录
        http.logout()
                .logoutSuccessUrl("/login");

        // 请求的限制访问：除去antMatchers都需要登录；允许剩余全部请求
        String[] antMatchers = {"/login", "/saveLogin", "/error", "/css/**", "/imgs/**", "/js/**"};
        http.authorizeRequests()
                .antMatchers(antMatchers).permitAll()
                .anyRequest().authenticated();

        // RememberMe
        http.rememberMe()
                .tokenRepository(persistentTokenRepository)
                .rememberMeParameter("remember")
                .tokenValiditySeconds(60)
                .userDetailsService(userDetails);

        // 指定访问拒绝handler
        http.exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler);

        // 允许iFreame嵌套
        http.headers()
                .frameOptions().disable();
    }
}
