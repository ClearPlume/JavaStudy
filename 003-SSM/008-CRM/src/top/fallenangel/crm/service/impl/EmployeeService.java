package top.fallenangel.crm.service.impl;

import org.springframework.stereotype.Service;
import top.fallenangel.crm.model.dao.IEmployeeDao;
import top.fallenangel.crm.model.entity.Employee;
import top.fallenangel.crm.service.IEmployeeService;

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
}