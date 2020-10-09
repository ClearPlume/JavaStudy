package top.fallenangel.servlet;

import top.fallenangel.util.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "LogoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        req.setAttribute("user", user);
        req.getSession().removeAttribute("user");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        Date curDate = new Date();

        CookieUtil.setCookie(resp, "lastLoginTime", sdf.format(curDate), 60 * 60 * 24 * 30);

        req.getRequestDispatcher("/logout.jsp").forward(req, resp);
    }
}