package top.fallenangel.employee.controller;

import org.springframework.stereotype.Controller;
import top.fallenangel.employee.model.bean.Employee;
import top.fallenangel.employee.service.IEmployeeService;

import java.util.List;

@Controller
public class EmployeeController {
    private final IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> list() {
        return employeeService.list();
    }

    public void save(Employee newEmployee) {
        employeeService.save(newEmployee);
    }

    public void modify(Employee employee) {
        employeeService.modify(employee);
    }

    public void delete(Integer empId) {
        employeeService.delete(empId);
    }

    public List<Employee> get(Employee employee) {
        return employeeService.get(employee);
    }
}