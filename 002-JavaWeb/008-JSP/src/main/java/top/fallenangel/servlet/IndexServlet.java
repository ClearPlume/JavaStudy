package top.fallenangel.servlet;

import top.fallenangel.bean.User;
import top.fallenangel.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    private List<User> users = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBUtil.connection("db_bjpowernode.properties", getClass().getClassLoader());
        users = DBUtil.query(User.class, "SELECT name, age, sex, hobbies, email, phone FROM tb_user");
        DBUtil.close();
        req.getSession().setAttribute("users", users);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    public List<User> getUsers() {
        return users;
    }

    public int getUsersNum() {
        return users.size();
    }
}