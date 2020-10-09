package top.fallenangel.dao;

import top.fallenangel.bean.Employee;

import java.util.List;
import java.util.Map;

public interface IEmployeeDao {
    List<Employee> getEmployees();

    List<Employee> getEmployeesWithPage(int pageStart, int pageSize);

    int count();

    void insertEmployee(Employee employee);

    void modifyEmployee(Employee employee);

    Employee queryEmployeeByNo(int empNo);

    List<Map<String, Object>> queryJob();
}