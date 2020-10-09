package top.fallenangel.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "ValidCodeFilter", servletNames = {"UserServlet"})
public class ValidCodeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        if (req.getParameterMap().containsKey("valid-code")) {
            String trueValidCode = req.getSession().getAttribute("trueValidCode").toString();
            String validCode = req.getParameter("valid-code");

            if (trueValidCode.equalsIgnoreCase(validCode)) {
                req.getSession().removeAttribute("trueValidCode");
                filterChain.doFilter(req, resp);
            } else {
                req.getSession().removeAttribute("trueValidCode");
                String targetURI = req.getParameter("targetURI");
                req.getSession().setAttribute("targetURI", targetURI);
                req.getSession().setAttribute("errorType", "验证码输入有误");
                resp.sendRedirect("/012_Mybatis/error.jsp");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}