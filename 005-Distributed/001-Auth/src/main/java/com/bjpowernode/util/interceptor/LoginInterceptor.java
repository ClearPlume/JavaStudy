package com.bjpowernode.util.interceptor;

import com.bjpowernode.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User loginUser = (User)request.getSession().getAttribute("loginUser");

        if(loginUser == null){
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        return true;
    }
}
