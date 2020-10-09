package top.fallenangel.web;

import top.fallenangel.bean.User;
import top.fallenangel.service.IUserService;
import top.fallenangel.service.impl.UserServiceImpl;
import top.fallenangel.util.BeanUtil;
import top.fallenangel.util.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = "/userAction")
public class UserServlet extends BaseServlet {
    private final IUserService userService = new UserServiceImpl();

    protected void checkAutoLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (CookieUtil.hasCookies(req) && CookieUtil.hasTargetCookie(req, "user")) {
            User user = userService.query(CookieUtil.getCookie(req, "user"));
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/012_Mybatis/employeeAction?action=list");
        } else {
            resp.sendRedirect("/012_Mybatis/login.html");
        }
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (CookieUtil.hasCookies(req) && CookieUtil.hasTargetCookie(req, "user")) {
            User user = userService.query(CookieUtil.getCookie(req, "user"));
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/012_Mybatis/employeeAction?action=list");
        } else {
            User loginUser = BeanUtil.formToBean(User.class, req.getParameterMap());
            User user = userService.login(loginUser.getName(), loginUser.getPwd());
            if (user != null) {
                req.getSession().setAttribute("user", user);
                resp.sendRedirect("/012_Mybatis/employeeAction?action=list");
            } else {
                String targetURI = req.getParameter("targetURI");
                req.getSession().setAttribute("targetURI", targetURI);
                req.getSession().setAttribute("errorType", "用户名或密码错误");
                resp.sendRedirect("/012_Mybatis/error.jsp");
            }
        }
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    protected void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}