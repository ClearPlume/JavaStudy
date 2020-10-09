package top.fallenangel.service.impl;

import top.fallenangel.bean.Employee;
import top.fallenangel.dao.IEmployeeDao;
import top.fallenangel.dao.impl.EmployeeDaoImpl;
import top.fallenangel.service.IEmployeeService;

import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements IEmployeeService {
    private final IEmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    @Override
    public List<Employee> getEmployeesWithPage(int pageStart, int pageSize) {
        return employeeDao.getEmployeesWithPage(pageStart, pageSize);
    }

    @Override
    public int count() {
        return employeeDao.count();
    }

    @Override
    public void insertEmployee(Employee employee) {
        employeeDao.insertEmployee(employee);
    }

    @Override
    public void modifyEmployee(Employee employee) {
        employeeDao.modifyEmployee(employee);
    }

    @Override
    public Employee queryEmployeeByNo(int empNo) {
        return employeeDao.queryEmployeeByNo(empNo);
    }

    @Override
    public List<Map<String, Object>> queryJob() {
        return employeeDao.queryJob();
    }
}