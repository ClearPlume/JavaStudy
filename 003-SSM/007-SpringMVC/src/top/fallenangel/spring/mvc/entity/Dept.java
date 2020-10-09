package top.fallenangel.spring.mvc.entity;

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
     * 部门区域
     */
    private Area area;

    /**
     * 部门名称
     */
    private String deptName;

    private static final long serialVersionUID = 1L;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}