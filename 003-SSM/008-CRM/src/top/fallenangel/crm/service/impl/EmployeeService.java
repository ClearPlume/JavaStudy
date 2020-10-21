package top.fallenangel.crm.service.impl;

import org.springframework.stereotype.Service;
import top.fallenangel.crm.model.dao.IEmployeeDao;
import top.fallenangel.crm.model.entity.Employee;
import top.fallenangel.crm.service.IEmployeeService;
import top.fallenangel.crm.util.Util;

import java.util.Date;
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
    public Employee get(int employeeId) {
        return employeeDao.selectByPrimaryKey(employeeId);
    }

    @Override
    public void update(Employee employee) {
        employee.setUpdateBy(1);
        employee.setUpdateTime(new Date());
        employee.setUpdater("坠天使");

        employeeDao.updateByPrimaryKeySelective(employee);
    }

    @Override
    public void save(Employee employee) {
        employee.setEmployeePwd(Util.md5(employee.getEmployeePwd()));

        employee.setCreateBy(1);
        employee.setCreateTime(new Date());
        employee.setCreator("坠天使");

        employee.setUpdateBy(1);
        employee.setUpdateTime(new Date());
        employee.setUpdater("坠天使");

        employeeDao.insertSelective(employee);
    }

    @Override
    public void lock(int[] employeeId) {
        employeeDao.lockAllByPrimaryKey(employeeId);
    }

    @Override
    public void unlock(int[] employeeId) {
        employeeDao.unlockAllByPrimaryKey(employeeId);
    }
}