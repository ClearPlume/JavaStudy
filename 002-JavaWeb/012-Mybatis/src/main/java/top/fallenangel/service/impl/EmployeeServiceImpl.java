package top.fallenangel.service.impl;

import top.fallenangel.bean.Employee;
import top.fallenangel.mapper.EmployeeMapper;
import top.fallenangel.service.IEmployeeService;
import top.fallenangel.util.MybatisUtil;

import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements IEmployeeService {
    private final EmployeeMapper employeeMapper;

    {
        MybatisUtil.initial(MybatisUtil.getResource("SqlMapConfig.xml"));
        employeeMapper = MybatisUtil.getMapper(EmployeeMapper.class);
    }

    @Override
    public int count() {
        return employeeMapper.count();
    }

    @Override
    public List<Employee> getEmployeesWithPage(int pageStart, int pageSize) {
        return employeeMapper.getEmployeesWithPage(pageStart, pageSize);
    }

    @Override
    public Employee query(int empNo) {
        return employeeMapper.query(empNo);
    }

    @Override
    public List<Map<String, Object>> jobs() {
        return employeeMapper.jobs();
    }

    @Override
    public void insert(Employee employee) {
        employeeMapper.insert(employee);
    }

    @Override
    public void modify(Employee employee) {
        employeeMapper.modify(employee);
    }

    @Override
    public void delete(int[] empnos) {
        employeeMapper.delete(empnos);
    }
}