package top.fallenangel.crm.model.dao;

import org.apache.ibatis.annotations.Param;
import top.fallenangel.crm.model.entity.Employee;
import top.fallenangel.crm.template.ITemplateDao;

import java.util.List;

public interface IEmployeeDao extends ITemplateDao<Employee> {
    int deleteByPrimaryKey(Integer employeeId);

    void lockAllByPrimaryKey(int[] employeeId);

    void unlockAllByPrimaryKey(int[] employeeId);

    Employee login(Employee employee);

    int checkPwd(@Param("employeeId") int employeeId, @Param("pwd") String pwd);

    List<Employee> selectAll(Employee employee);

    void updatePwd(@Param("employeeId") int employeeId, @Param("pwd") String pwd);
}