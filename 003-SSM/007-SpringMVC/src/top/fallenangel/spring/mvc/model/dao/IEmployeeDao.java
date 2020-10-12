package top.fallenangel.spring.mvc.model.dao;

import top.fallenangel.spring.mvc.entity.Employee;

import java.util.List;

public interface IEmployeeDao {
    int deleteAll(Integer[] empId);

    int deleteByPrimaryKey(Integer empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer empId);

    List<Employee> selectAll(Employee employee);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}