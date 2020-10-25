package top.fallenangel.crm.service;

import top.fallenangel.crm.model.entity.Employee;
import top.fallenangel.crm.template.ITemplateService;

import java.util.List;

public interface IEmployeeService extends ITemplateService<Employee> {
    List<Employee> list(Employee employee);

    Employee login(Employee employee);

    boolean checkPwd(int employeeId, String pwd);

    void lock(int[] employeeId);

    void unlock(int[] employeeId);

    void updatePwd(int employeeId, String pwd);
}