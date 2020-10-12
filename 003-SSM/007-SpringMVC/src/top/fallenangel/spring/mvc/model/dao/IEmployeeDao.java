package top.fallenangel.spring.mvc.model.dao;

import org.apache.ibatis.annotations.Param;
import top.fallenangel.spring.mvc.entity.Employee;
import top.fallenangel.spring.mvc.util.Pager;

import java.util.List;

public interface IEmployeeDao {
    int deleteAll(Integer[] empId);

    int deleteByPrimaryKey(Integer empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer empId);

    List<Employee> selectAll(@Param("employee") Employee employee, @Param("pager") Pager pager);

    Integer count(@Param("employee") Employee employee);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}