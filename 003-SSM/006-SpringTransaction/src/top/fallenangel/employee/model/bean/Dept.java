package top.fallenangel.employee.model.bean;

import java.io.Serializable;

/**
 * t_dept 部门表
 *
 * @author 坠天使
 */
public class Dept implements Serializable {
    /**
     * 部门ID
     */
    private Integer deptId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 部门区域
     */
    private Area area;

    private static final long serialVersionUID = 1L;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dept dept = (Dept) o;

        if (!deptId.equals(dept.deptId)) return false;
        if (!deptName.equals(dept.deptName)) return false;
        return area.equals(dept.area);
    }

    @Override
    public int hashCode() {
        int result = deptId.hashCode();
        result = 31 * result + deptName.hashCode();
        result = 31 * result + area.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", area=" + area +
                '}';
    }
}