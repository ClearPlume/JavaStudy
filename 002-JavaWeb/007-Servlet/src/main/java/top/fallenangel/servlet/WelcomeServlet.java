package top.fallenangel.servlet;

import top.fallenangel.bean.User;
import top.fallenangel.util.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "WelcomeServlet", urlPatterns = "/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        Date curDate = new Date();

        boolean hasLastLoginTime = CookieUtil.hasTargetCookie(req, "lastLoginTime");
        if (!hasLastLoginTime) {
            CookieUtil.setCookie(resp, "lastLoginTime", sdf.format(curDate), 60 * 60 * 24 * 30);
        }

        User user;

        if (null == req.getSession().getAttribute("user")) {
            user = new User();
            user.setName(CookieUtil.getCookie(req, "name"));
            user.setPwd(CookieUtil.getCookie(req, "pwd"));
            req.getSession().setAttribute("user", user);
        } else {
            user = (User) req.getSession().getAttribute("user");
        }

        req.getSession().setAttribute("user", user);
        req.getSession().setAttribute("lastLoginTime", hasLastLoginTime ? CookieUtil.getCookie(req, "lastLoginTime") : sdf.format(curDate));

        req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
    }
}