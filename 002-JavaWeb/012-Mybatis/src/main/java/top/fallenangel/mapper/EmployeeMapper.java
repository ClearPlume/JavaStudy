package top.fallenangel.mapper;

import org.apache.ibatis.annotations.Param;
import top.fallenangel.bean.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    /**
     * 查询记录总数
     *
     * @return 记录总数
     */
    int count();

    /**
     * 分页查找员工
     *
     * @param pageStart 页面开始的记录
     * @param pageSize  页面大小
     * @return 该页的员工信息
     */
    List<Employee> getEmployeesWithPage(@Param("pageStart") int pageStart, @Param("pageSize") int pageSize);

    /**
     * 根据编号查找员工
     *
     * @param empNo 编号
     * @return 员工
     */
    Employee query(int empNo);

    /**
     * 查找全部工作
     *
     * @return 全部工作
     */
    List<Map<String, Object>> jobs();

    /**
     * 插入员工
     *
     * @param employee 要插入的员工
     */
    void insert(Employee employee);

    /**
     * 更新员工信息
     *
     * @param employee 员工
     */
    void modify(Employee employee);

    /**
     * 删除指定编号的员工
     *
     * @param empnos 要删除的员工编号
     */
    void delete(int[] empnos);
}