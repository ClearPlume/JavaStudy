package top.fallenangel.security.model.entity;

import java.util.List;

public class Role {
    private Integer roleId;

    private String roleName;

    private String roleCode;

    private Integer roleStatus;

    private List<Integer> authIds;

    public List<Integer> getAuthIds() {
        return authIds;
    }

    public void setAuthIds(List<Integer> authIds) {
        this.authIds = authIds;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public Integer getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }
}