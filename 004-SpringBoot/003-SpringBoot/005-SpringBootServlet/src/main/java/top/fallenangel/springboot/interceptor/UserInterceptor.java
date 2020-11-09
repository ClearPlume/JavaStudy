package top.fallenangel.springboot.interceptor;

import org.springframework.lang.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        /*
         * 项目中有Servlet和Filter、Interceptor
         *
         * 执行优先级为：Filter、Servlet、Interceptor
         *
         * 请求会先过Filter，随后被Servlet；若Servlet不匹配无法处理，才会过Interceptor
         *
         * 所以正常访问到页面时，请求被处理，就不会再过Interceptor。
         */
        System.out.println("经过了拦截器");

        if (request.getRequestURI().contains("user")) {
            return true;
        } else {
            response.setContentType("text/html; charset=utf-8");
            response.getWriter().write("本次访问不合法！");
            return false;
        }
    }
}
