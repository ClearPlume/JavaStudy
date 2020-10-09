package top.fallenangel.employee.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.fallenangel.employee.model.bean.Employee;
import top.fallenangel.employee.model.dao.IEmployeeDao;
import top.fallenangel.employee.service.IEmployeeService;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    private final IEmployeeDao employeeDao;

    public EmployeeService(IEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDao.insert(employee);
    }

    @Override
    @Transactional
    public void delete(Integer empId) {
        employeeDao.deleteByPrimaryKey(empId);
    }

    @Override
    @Transactional
    public void modify(Employee employee) {
        employeeDao.updateByPrimaryKey(employee);
    }

    @Override
    public Employee get(Integer empId) {
        return employeeDao.selectByPrimaryKey(empId);
    }

    @Override
    public List<Employee> list() {
        return employeeDao.selectAll();
    }

    @Override
    public List<Employee> get(Employee employee) {
        return employeeDao.selectAllByVO(employee);
    }
}