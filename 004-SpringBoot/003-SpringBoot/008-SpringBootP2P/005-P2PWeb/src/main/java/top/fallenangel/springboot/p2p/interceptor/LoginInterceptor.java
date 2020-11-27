package top.fallenangel.springboot.p2p.interceptor;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.HandlerInterceptor;
import top.fallenangel.springboot.p2p.common.Constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        Object user = request.getSession().getAttribute(Constants.LOGIN_USER);
        if (user == null) {
            response.sendRedirect("/P2PWeb/loan/page/login");
            return false;
        }
        return true;
    }
}
