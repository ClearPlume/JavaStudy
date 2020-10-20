package top.fallenangel.crm.service;

import top.fallenangel.crm.model.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> list(Employee employee);
}