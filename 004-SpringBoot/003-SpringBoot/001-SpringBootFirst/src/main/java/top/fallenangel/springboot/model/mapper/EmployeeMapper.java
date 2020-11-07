package top.fallenangel.springboot.model.mapper;

import org.springframework.stereotype.Repository;
import top.fallenangel.springboot.model.entity.Employee;

@Repository
public interface EmployeeMapper {
    int insert(Employee record);

    int insertSelective(Employee record);

    int deleteByPrimaryKey(Integer employeeId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    Employee selectByPrimaryKey(Integer employeeId);

    int count();
}