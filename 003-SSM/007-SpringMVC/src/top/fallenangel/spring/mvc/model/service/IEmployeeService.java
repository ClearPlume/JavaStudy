package top.fallenangel.spring.mvc.model.service;

import top.fallenangel.spring.mvc.entity.Employee;
import top.fallenangel.spring.mvc.util.Pager;

import java.util.List;

public interface IEmployeeService {
    Employee get(Integer empId);

    List<Employee> list(Employee employee, Pager pager);

    void save(Employee employee);

    void delete(Integer[] empId);

    void modify(Employee employee);

    Integer count(Employee employee);
}