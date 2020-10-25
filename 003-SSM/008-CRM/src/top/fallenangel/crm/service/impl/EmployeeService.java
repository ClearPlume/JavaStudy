package top.fallenangel.crm.service.impl;

import org.springframework.stereotype.Service;
import top.fallenangel.crm.model.dao.IEmployeeDao;
import top.fallenangel.crm.model.entity.Employee;
import top.fallenangel.crm.service.IEmployeeService;
import top.fallenangel.crm.template.ITemplateDao;
import top.fallenangel.crm.template.impl.TemplateService;
import top.fallenangel.crm.util.Util;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeService extends TemplateService<Employee> implements IEmployeeService {
    private final IEmployeeDao employeeDao;

    public EmployeeService(IEmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public ITemplateDao<Employee> getDao() {
        return employeeDao;
    }

    @Override
    public List<Employee> list(Employee employee) {
        return employeeDao.selectAll(employee);
    }

    @Override
    public Employee login(Employee employee) {
        employee.setEmployeePwd(Util.md5(employee.getEmployeePwd()));

        employee.setEmployeeAllowedIps(Util.getRequest().getRemoteAddr());

        employee.setUpdateTime(new Date());

        return employeeDao.login(employee);
    }

    @Override
    public boolean checkPwd(int employeeId, String pwd) {
        return employeeDao.checkPwd(employeeId, pwd) == 1;
    }

    @Override
    public int save(Employee employee) {
        employee.setEmployeePwd(Util.md5(employee.getEmployeePwd()));
        return super.save(employee);
    }

    @Override
    public void lock(int[] employeeId) {
        employeeDao.lockAllByPrimaryKey(employeeId);
    }

    @Override
    public void unlock(int[] employeeId) {
        employeeDao.unlockAllByPrimaryKey(employeeId);
    }

    @Override
    public void updatePwd(int employeeId, String pwd) {
        employeeDao.updatePwd(employeeId, pwd);
    }
}