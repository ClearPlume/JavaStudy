package top.fallenangel.spring.mvc.model.service.impl;

import org.springframework.stereotype.Service;
import top.fallenangel.spring.mvc.entity.Employee;
import top.fallenangel.spring.mvc.model.dao.IEmployeeDao;
import top.fallenangel.spring.mvc.model.service.IEmployeeService;
import top.fallenangel.spring.mvc.util.Pager;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    private final IEmployeeDao employeeDao;

    public EmployeeService(IEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> list(Employee employee, Pager pager) {
        pager.setTotalRecord(employeeDao.count(employee));
        return employeeDao.selectAll(employee, pager);
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

    @Override
    public Integer count(Employee employee) {
        return employeeDao.count(employee);
    }
}