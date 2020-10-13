package top.fallenangel.spring.mvc.util.filter;

import org.springframework.lang.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;
import top.fallenangel.spring.mvc.controller.UserController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        Object user = request.getSession().getAttribute(UserController.LOGIN_USER);

        if (user == null) {
            request.getRequestDispatcher("/user/loginPage").forward(request, response);
            return false;
        }

        return true;
    }
}