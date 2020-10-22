package top.fallenangel.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.fallenangel.crm.model.entity.Employee;
import top.fallenangel.crm.service.IEmployeeService;
import top.fallenangel.crm.util.Constants;
import top.fallenangel.crm.util.Util;

@Controller
public class LoginController {
    private final IEmployeeService employeeService;

    public LoginController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("login")
    public String login(Employee employee) {
        Employee employeeDB = employeeService.login(employee);
        if (employeeDB == null) {
            employee.setMsg("登录失败，请检查用户名或密码！");
            return "login";
        }
        Util.putObjectInSession(Constants.LOGIN_EMPLOYEE, employeeDB);
        return "redirect:index";
    }

    @RequestMapping("logout")
    public String logout() {
        Util.removeObjectFromSession(Constants.LOGIN_EMPLOYEE);
        return "redirect:index";
    }
}