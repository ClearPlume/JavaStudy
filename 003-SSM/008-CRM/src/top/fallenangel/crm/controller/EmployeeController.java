package top.fallenangel.crm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.fallenangel.crm.model.entity.Dept;
import top.fallenangel.crm.model.entity.Employee;
import top.fallenangel.crm.service.IDeptService;
import top.fallenangel.crm.service.IEmployeeService;

import java.util.ArrayList;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    private final IEmployeeService employeeService;
    private final IDeptService deptService;

    public EmployeeController(IEmployeeService employeeService, IDeptService deptService) {
        this.employeeService = employeeService;
        this.deptService = deptService;
    }

    @RequestMapping("list")
    public PageInfo<Employee> list(Employee employee, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize, ArrayList<Dept> depts) {
        depts.addAll(deptService.list());

        PageHelper.startPage(page, pageSize);
        return PageInfo.of(employeeService.list(employee));
    }
}