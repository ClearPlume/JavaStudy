package top.fallenangel.springtransaction.controller;

import top.fallenangel.service.IEmployeeService;
import top.fallenangel.service.impl.EmployeeServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "QueryJobServlet", urlPatterns = "/queryJob")
public class QueryJobServlet extends HttpServlet {
    private final IEmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Map<String, Object>> jobs = employeeService.queryJob();
        req.getSession().setAttribute("jobs", jobs);
        resp.sendRedirect("/009_MVC/insert_emp.jsp");
    }
}