package top.fallenangel.servlet;

import top.fallenangel.bean.User;
import top.fallenangel.util.BeanUtil;
import top.fallenangel.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        User user = BeanUtil.formToBean(User.class, req.getParameterMap());
        DBUtil.connection("db_bjpowernode.properties", getClass().getClassLoader());
        try {
            int recordNum = DBUtil.queryRecordNum(user.getName());

            if (recordNum == 1) {
                req.setAttribute("errorType", "用户已存在");
                req.getRequestDispatcher("/register_error.jsp").forward(req, resp);
            } else {
                DBUtil.begin();
                DBUtil.update("INSERT INTO tb_user(name, age, sex, hobbies, email, phone, pwd) VALUES (?, ?, ?, ?, ?, ?, ?)", user.getName(), user.getAge(), user.getSex(), Arrays.toString(user.getHobbies()), user.getEmail(), user.getPhone(), user.getPwd());
                DBUtil.commit();
                resp.sendRedirect("/register_success.html");
            }
        } catch (Exception e) {
            req.setAttribute("errorType", "未知原因");
            req.getRequestDispatcher("/register_error.jsp").forward(req, resp);
            DBUtil.rollback();
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
    }
}