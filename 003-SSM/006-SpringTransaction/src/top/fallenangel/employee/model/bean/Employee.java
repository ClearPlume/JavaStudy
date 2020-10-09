package top.fallenangel.employee.model.bean;

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

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (!empId.equals(employee.empId)) return false;
        if (!empName.equals(employee.empName)) return false;
        return dept.equals(employee.dept);
    }

    @Override
    public int hashCode() {
        int result = empId.hashCode();
        result = 31 * result + empName.hashCode();
        result = 31 * result + dept.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", dept=" + dept +
                '}';
    }
}