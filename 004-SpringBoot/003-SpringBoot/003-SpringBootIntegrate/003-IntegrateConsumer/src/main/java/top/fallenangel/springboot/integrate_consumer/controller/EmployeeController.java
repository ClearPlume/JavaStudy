package top.fallenangel.springboot.integrate_consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fallenangel.springboot.integrate_interface.model.entity.Employee;
import top.fallenangel.springboot.integrate_interface.service.IEmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Reference(interfaceClass = IEmployeeService.class, version = "1.0.0", timeout = 15000)
    private IEmployeeService employeeService;

    @GetMapping("view/{id}")
    public Employee view(@PathVariable("id") int id) {
        return employeeService.view(id);
    }

    @GetMapping("count")
    public int count() {
        return employeeService.count();
    }
}
