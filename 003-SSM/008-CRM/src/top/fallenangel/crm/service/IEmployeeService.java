package top.fallenangel.crm.service;

import top.fallenangel.crm.model.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> list(Employee employee);

    Employee get(int employeeId);

    void update(Employee employee);

    void save(Employee employee);

    void lock(int[] employeeId);

    void unlock(int[] employeeId);
}