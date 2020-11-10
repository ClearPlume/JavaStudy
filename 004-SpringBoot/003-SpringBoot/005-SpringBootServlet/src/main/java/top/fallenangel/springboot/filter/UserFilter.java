package top.fallenangel.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("经过了过滤器");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
