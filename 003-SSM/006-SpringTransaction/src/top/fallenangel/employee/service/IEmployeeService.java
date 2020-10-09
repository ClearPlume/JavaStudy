package top.fallenangel.employee.service;

import top.fallenangel.employee.model.bean.Employee;

import java.util.List;

public interface IEmployeeService {
    void save(Employee employee);

    void delete(Integer empId);

    void modify(Employee employee);

    Employee get(Integer empId);

    List<Employee> list();

    List<Employee> get(Employee employee);
}