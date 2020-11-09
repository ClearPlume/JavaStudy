package top.fallenangel.springboot.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("ISO-8859-1");
        resp.setContentType("text/html; charset=UTF-8");

        String name = req.getParameter("name");
        resp.getWriter().write("你好，" + name + "！");
    }
}
