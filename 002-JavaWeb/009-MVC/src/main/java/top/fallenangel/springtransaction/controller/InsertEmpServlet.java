package top.fallenangel.springtransaction.controller;

import top.fallenangel.bean.Employee;
import top.fallenangel.service.IEmployeeService;
import top.fallenangel.service.impl.EmployeeServiceImpl;
import top.fallenangel.util.BeanUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertEmpServlet", urlPatterns = "/insertEmp")
public class InsertEmpServlet extends HttpServlet {
    private final IEmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = BeanUtil.formToBean(Employee.class, req.getParameterMap());
        employeeService.insertEmployee(employee);
        req.getRequestDispatcher("/employee").forward(req, resp);
    }
}