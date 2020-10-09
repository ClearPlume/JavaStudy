package top.fallenangel.springtransaction.controller;

import top.fallenangel.bean.Employee;
import top.fallenangel.service.IEmployeeService;
import top.fallenangel.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {
    private final IEmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int pageSize = 5;

        String pageStr = req.getParameter("page");
        int page = Integer.parseInt(pageStr == null ? "1" : pageStr);
        int pages = employeeService.count() / pageSize + (employeeService.count() % pageSize == 0 ? 0 : 1);
        int pageStart = (page - 1) * pageSize;

        List<Employee> employees = employeeService.getEmployeesWithPage(pageStart, pageSize);
        req.getSession().setAttribute("pages", pages);
        req.getSession().setAttribute("employees", employees);
        resp.sendRedirect("/009_MVC/employee.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}