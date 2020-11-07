package top.fallenangel.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fallenangel.springboot.model.entity.Employee;
import top.fallenangel.springboot.service.IEmployeeService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    private final IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("view/{id}")
    public Employee view(@PathVariable("id") int id) {
        return employeeService.get(id);
    }

    @GetMapping("count")
    public int count() {
        int count = 0;

        ExecutorService executor = Executors.newFixedThreadPool(8);

        for (int i = 0; i < 100; i++) {
            executor.submit(employeeService::count);
        }
        return count;
    }
}