package top.fallenangel.service;

import top.fallenangel.bean.Employee;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {
    int count();

    List<Map<String, Object>> getEmployeesWithPage(int pageStart, int pageSize);

    Employee query(int empNo);

    List<Map<String, Object>> jobs();

    void insert(Employee employee);

    void modify(Employee employee);

    void delete(int[] empnos);
}