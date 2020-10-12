package top.fallenangel.spring.mvc.model.service.impl;

import org.springframework.stereotype.Service;
import top.fallenangel.spring.mvc.entity.Employee;
import top.fallenangel.spring.mvc.model.dao.IEmployeeDao;
import top.fallenangel.spring.mvc.model.service.IEmployeeService;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    private final IEmployeeDao employeeDao;

    public EmployeeService(IEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> list(Employee employee) {
        return employeeDao.selectAll(employee);
    }

    @Override
    public void save(Employee employee) {
        employeeDao.insert(employee);
    }

    @Override
    public void modify(Employee employee) {
        employeeDao.updateByPrimaryKey(employee);
    }

    @Override
    public Employee get(Integer empId) {
        return employeeDao.selectByPrimaryKey(empId);
    }

    @Override
    public void delete(Integer[] empId) {
        employeeDao.deleteAll(empId);
    }
}