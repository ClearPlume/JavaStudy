package top.fallenangel.crm.model.entity;

import java.io.Serializable;

/**
 * t_dept 部门表
 *
 * @author 坠天使
 */
public class Dept implements Serializable {
    private Integer deptId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 部门编号
     */
    private String deptCode;

    /**
     * 部门状态(0 不可用,1 可用)
     */
    private Integer deptStatus;

    private String deptStatusStr;

    /**
     * 父部门的id
     */
    private Integer parentId;

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

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public Integer getDeptStatus() {
        return deptStatus;
    }

    public void setDeptStatus(Integer deptStatus) {
        this.deptStatus = deptStatus;
    }

    public String getDeptStatusStr() {
        deptStatusStr = deptStatus == 0 ? "<span style='color: red'>禁用</span>" : "<span style='color: green'>启用</span>";
        return deptStatusStr;
    }

    public void setDeptStatusStr(String deptStatusStr) {
        this.deptStatusStr = deptStatusStr;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}