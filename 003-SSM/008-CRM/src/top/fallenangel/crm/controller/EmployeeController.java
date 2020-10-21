package top.fallenangel.crm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.fallenangel.crm.model.entity.Employee;
import top.fallenangel.crm.service.IEmployeeService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    private final IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("list")
    public PageInfo<Employee> list(Employee employee, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return PageInfo.of(employeeService.list(employee));
    }
}