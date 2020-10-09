package top.fallenangel.springtransaction.controller;

import top.fallenangel.bean.Employee;
import top.fallenangel.service.IEmployeeService;
import top.fallenangel.service.impl.EmployeeServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "QueryEmpServlet", urlPatterns = "/queryEmp")
public class QueryEmpServlet extends HttpServlet {
    private final IEmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int empNo = Integer.parseInt(req.getParameter("emp-no"));
        Employee employee = employeeService.queryEmployeeByNo(empNo);
        List<Map<String, Object>> jobs = employeeService.queryJob();
        req.getSession().setAttribute("employee", employee);
        req.getSession().setAttribute("jobs", jobs);
        resp.getWriter().write("OK");
        resp.getWriter().flush();
    }
}