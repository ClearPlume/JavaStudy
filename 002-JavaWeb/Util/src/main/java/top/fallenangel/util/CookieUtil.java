package top.fallenangel.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    public static boolean hasCookies(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            return false;
        }
        return !(cookies.length == 1 && cookies[0].getName().equals("JSESSIONID"));
    }

    public static boolean hasTargetCookie(HttpServletRequest req, String name) {
        Cookie[] cookies = req.getCookies();
        boolean hasTargetCookie = false;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                hasTargetCookie = true;
                break;
            }
        }

        return hasTargetCookie;
    }

    public static String getCookie(HttpServletRequest req, String name) {
        Cookie[] cookies = req.getCookies();
        Cookie targetCookie = null;
        boolean hasTargetCookie = false;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                targetCookie = cookie;
                hasTargetCookie = true;
                break;
            }
        }

        return hasTargetCookie ? targetCookie.getValue() : null;
    }

    public static void setCookie(HttpServletResponse resp, String name, String value) {
        setCookie(resp, name, value, -1);
    }

    public static void setCookie(HttpServletResponse resp, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        resp.addCookie(cookie);
    }

    public static void deleteCookie(HttpServletResponse resp, String name) {
        setCookie(resp, name, "", 0);
    }
}