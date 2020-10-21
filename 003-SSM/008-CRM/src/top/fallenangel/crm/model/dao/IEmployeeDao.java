package top.fallenangel.crm.model.dao;

import top.fallenangel.crm.model.entity.Employee;

import java.util.List;

public interface IEmployeeDao {
    int deleteByPrimaryKey(Integer employeeId);

    void lockAllByPrimaryKey(int[] employeeId);

    void unlockAllByPrimaryKey(int[] employeeId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer employeeId);

    List<Employee> selectAll(Employee employee);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}