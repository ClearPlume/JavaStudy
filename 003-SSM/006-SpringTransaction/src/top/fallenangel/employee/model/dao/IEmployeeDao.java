package top.fallenangel.employee.model.dao;

import top.fallenangel.employee.model.bean.Employee;

import java.util.List;

public interface IEmployeeDao {
    int deleteByPrimaryKey(Integer empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer empId);

    List<Employee> selectAll();

    List<Employee> selectAllByVO(Employee employee);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}