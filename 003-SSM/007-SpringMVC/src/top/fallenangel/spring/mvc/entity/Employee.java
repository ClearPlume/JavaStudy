package top.fallenangel.spring.mvc.entity;

import java.io.Serializable;

/**
 * t_employee 员工表
 *
 * @author 坠天使
 */
public class Employee implements Serializable {
    /**
     * 员工ID
     */
    private Integer empId;

    /**
     * 员工姓名
     */
    private String empName;

    /**
     * 员工部门
     */
    private Dept dept;

    private static final long serialVersionUID = 1L;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}