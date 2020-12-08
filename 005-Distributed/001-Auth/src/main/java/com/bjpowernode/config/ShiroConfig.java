package com.bjpowernode.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.bjpowernode.util.shiro.AuthRealm;
import com.bjpowernode.util.shiro.FilterChainDefinitionMapBuilder;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordMatcher;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

    @Value("${spring.redis.host}")
    private String host;

    /**
     * 引入Realm对象
     */
    @Bean
    public AuthRealm createRealm(CacheManager cacheManager, CredentialsMatcher credentialsMatcher) {
        AuthRealm authRealm = new AuthRealm();

        authRealm.setAuthenticationCachingEnabled(true);
        authRealm.setCacheManager(cacheManager);
        authRealm.setCredentialsMatcher(credentialsMatcher);

        return authRealm;
    }

    /**
     * 引入安全管理器
     */
    @Bean
    public SecurityManager createSecurityManager(Realm realm, RememberMeManager rememberMeManager, SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        securityManager.setRealm(realm);
        securityManager.setRememberMeManager(rememberMeManager);
        securityManager.setSessionManager(sessionManager);

        return securityManager;
    }

    /**
     * 引入安全管理过滤器
     */
    @Bean
    public ShiroFilterFactoryBean createShiroFilterFactoryBean(SecurityManager securityManager, FilterChainDefinitionMapBuilder filterChainDefinitionMapBuilder) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/no_auth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMapBuilder.buildFilterChainDefinitionMap());

        return shiroFilterFactoryBean;
    }

    /**
     * 用户权限map构造器
     */
    @Bean
    public FilterChainDefinitionMapBuilder createFilterChainDefinitionMapBuilder() {
        return new FilterChainDefinitionMapBuilder();
    }

    /**
     * 启用Shiro的Thymeleaf支持
     */
    @Bean
    public ShiroDialect createShiroDialect() {
        return new ShiroDialect();
    }

    /**
     * 引入缓存管理器
     */
    @Bean
    public CacheManager createCacheManager(RedisManager redisManager) {

        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager);

        return redisCacheManager;
    }

    /**
     * 引入RedisManager
     */
    @Bean
    public RedisManager createRedisManager() {

        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setExpire(3600);

        return redisManager;
    }

    /**
     * 引入密码加密服务
     */
    @Bean
    public PasswordService createPasswordService() {
        return new DefaultPasswordService();
    }

    /**
     * 引入密码加密比较器
     */
    @Bean
    public CredentialsMatcher createCredentialsMatcher() {
        return new PasswordMatcher();
    }

    /**
     * 引入记住密码管理器
     */
    @Bean
    public RememberMeManager createRememberMeManager(Cookie cookie) {
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();

        rememberMeManager.setCookie(cookie);

        return rememberMeManager;
    }

    /**
     * 引入记住密码Cookie
     */
    @Bean
    public Cookie createRememberMeCookie() {
        SimpleCookie rememberMeCookie = new SimpleCookie("rememberMe");

        rememberMeCookie.setHttpOnly(true);
        rememberMeCookie.setMaxAge(3600 * 24 * 30);

        return rememberMeCookie;
    }

    /**
     * 会话管理器
     */
    @Bean
    public SessionManager createSessionManager(SessionDAO sessionDAO) {

        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();

        sessionManager.setSessionIdUrlRewritingEnabled(false);
        sessionManager.setSessionDAO(sessionDAO);

        return sessionManager;
    }

    /**
     * RedisSessionDAO
     */
    @Bean
    public SessionDAO createSessionDAO(RedisManager redisManager) {

        RedisSessionDAO sessionDAO = new RedisSessionDAO();

        sessionDAO.setRedisManager(redisManager);

        return sessionDAO;
    }
}
