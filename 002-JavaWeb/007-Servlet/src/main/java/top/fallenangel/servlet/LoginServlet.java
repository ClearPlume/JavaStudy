package top.fallenangel.servlet;

import top.fallenangel.ELoginResult;
import top.fallenangel.bean.User;
import top.fallenangel.util.BeanUtil;
import top.fallenangel.util.CookieUtil;
import top.fallenangel.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String validCode = req.getParameter("valid-code");
        String trueCode = req.getSession().getAttribute("true-code").toString();

        ELoginResult loginResult;

        if (trueCode.equalsIgnoreCase(validCode)) {
            User user;

            if (CookieUtil.hasCookies(req) && CookieUtil.hasTargetCookie(req, "name")) {
                user = new User();
                if (CookieUtil.hasTargetCookie(req, "name")) {
                    user.setName(CookieUtil.getCookie(req, "name"));
                }
                if (CookieUtil.hasTargetCookie(req, "pwd")) {
                    user.setPwd(CookieUtil.getCookie(req, "pwd"));
                }
            } else {
                user = BeanUtil.formToBean(User.class, req.getParameterMap());
            }

            loginResult = login(user);

            if (loginResult == ELoginResult.SUCCESS) {
                req.getSession().setAttribute("user", user);

                if (req.getParameterMap().containsKey("auto-login")) {
                    CookieUtil.setCookie(resp, "name", user.getName(), 60 * 60 * 24 * 7);
                    CookieUtil.setCookie(resp, "pwd", user.getPwd(), 60 * 60 * 24 * 7);
                } else {
                    CookieUtil.deleteCookie(resp, "name");
                    CookieUtil.deleteCookie(resp, "pwd");
                }
            }
        } else {
            loginResult = ELoginResult.VALID_CODE_ERROR;
        }

        String errorType = "";

        switch (loginResult) {
            case VALID_CODE_ERROR:
                errorType = "验证码错误";
                break;
            case NO_RECORD:
                errorType = "用户不存在";
                break;
            case NAME_PWD_ERROR:
                errorType = "用户名或密码错误";
                break;
            case SUCCESS:
                req.getRequestDispatcher("/welcome").forward(req, resp);
                break;
        }

        if (loginResult != ELoginResult.SUCCESS) {
            req.getSession().setAttribute("errorType", errorType);
            req.getRequestDispatcher("/login_error.jsp").forward(req, resp);
        }
    }

    private ELoginResult login(User user) {
        ELoginResult result;
        DBUtil.connection("db_bjpowernode.properties", getClass().getClassLoader());
        int recordNum = DBUtil.queryRecordNum("SELECT count(*) FROM tb_user WHERE name = ?", user.getName());

        if (recordNum == 1) {
            User userRecord = DBUtil.querySingleRecord(User.class, "SELECT pwd FROM tb_user WHERE name=?", user.getName());

            if (user.getPwd().equals(userRecord.getPwd())) {
                result = ELoginResult.SUCCESS;
            } else {
                result = ELoginResult.NAME_PWD_ERROR;
            }
        } else {
            result = ELoginResult.NO_RECORD;
        }

        DBUtil.close();
        return result;
    }
}