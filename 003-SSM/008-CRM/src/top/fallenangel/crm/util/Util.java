package top.fallenangel.crm.util;

import org.springframework.util.DigestUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.fallenangel.crm.model.entity.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    public static String dateFormat(Date date, String pattern) {
        return date == null ? "" : new SimpleDateFormat(pattern).format(date);
    }

    public static String md5(String src) {
        return DigestUtils.md5DigestAsHex(src.getBytes());
    }

    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static void putObjectInSession(String key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static void removeObjectFromSession(String key) {
        getSession().removeAttribute(key);
    }

    public static Employee getEmployeeFromSession() {
        return (Employee) getSession().getAttribute(Constants.LOGIN_EMPLOYEE);
    }

    public static Integer getEmployeeIdFromSession() {
        return getEmployeeFromSession().getEmployeeId();
    }
}