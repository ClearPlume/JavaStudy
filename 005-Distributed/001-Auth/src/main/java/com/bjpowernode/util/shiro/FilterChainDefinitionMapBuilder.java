package com.bjpowernode.util.shiro;

import com.bjpowernode.model.entity.Auth;
import com.bjpowernode.service.impl.AuthService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FilterChainDefinitionMapBuilder
{
    @Autowired
    private AuthService authService;

    public Map<String, String> buildFilterChainDefinitionMap()
    {
        Map<String, String> authMap = new LinkedHashMap<>();

        authMap.put("/saveLogin", "anon");
        authMap.put("/error", "anon");
        authMap.put("/**/imgs/**", "anon");
        authMap.put("/**/css/**", "anon");
        authMap.put("/**/js/**", "anon");

        List<Auth> auths = authService.list();
        for (Auth auth : auths)
        {
            String[] urls = auth.getAuthUrl().split(",");

            for (String url : urls)
            {
                authMap.put("/" + url, "perms[" + auth.getAuthCode() + "]");
            }
        }

        authMap.put("/**", "user");

        return authMap;
    }
}
