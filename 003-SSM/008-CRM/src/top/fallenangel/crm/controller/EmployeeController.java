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

    @RequestMapping("detail")
    public Employee detail(int employeeId) {
        return employeeService.get(employeeId);
    }

    @RequestMapping("update")
    public String update(Employee employee) {
        employeeService.update(employee);
        return "redirect:/employee/list";
    }

    @RequestMapping("save")
    public String save(Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee/list";
    }

    @RequestMapping("lock")
    public String lock(int[] employeeId) {
        employeeService.lock(employeeId);
        return "redirect:/employee/list";
    }

    @RequestMapping("unlock")
    public String unlock(int[] employeeId) {
        employeeService.unlock(employeeId);
        return "redirect:/employee/list";
    }
}