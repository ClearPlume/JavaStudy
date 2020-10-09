package top.fallenangel.servlet;

import top.fallenangel.util.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BeforeLoginServlet", urlPatterns = "/beforeLogin")
public class BeforeLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (CookieUtil.hasCookies(req) && CookieUtil.hasTargetCookie(req, "name")) {
            req.getRequestDispatcher("/welcome").forward(req, resp);
        } else {
            resp.sendRedirect("/007_Servlet/login.html");
        }
    }
}