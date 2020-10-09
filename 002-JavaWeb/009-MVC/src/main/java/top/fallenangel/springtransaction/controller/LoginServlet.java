package top.fallenangel.springtransaction.controller;

import top.fallenangel.bean.User;
import top.fallenangel.service.ILoginService;
import top.fallenangel.service.impl.LoginServiceImpl;
import top.fallenangel.util.BeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private final ILoginService loginService = new LoginServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User loginUser = BeanUtil.formToBean(User.class, req.getParameterMap());
        User user = loginService.login(loginUser);
        if (null != user) {
            req.getSession().setAttribute("user", user);
            req.getRequestDispatcher("/employee").forward(req, resp);
        }
    }
}