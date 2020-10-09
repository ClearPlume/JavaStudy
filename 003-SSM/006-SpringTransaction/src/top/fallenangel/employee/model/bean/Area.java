package top.fallenangel.employee.model.bean;

import java.io.Serializable;

/**
 * t_area 行政区域表
 *
 * @author 坠天使
 */
public class Area implements Serializable {
    /**
     * 区域ID
     */
    private Integer areaId;

    /**
     * 父级区域ID
     */
    private Integer parentAreaId;

    /**
     * 区域名称
     */
    private String areaName;

    private static final long serialVersionUID = 1L;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getParentAreaId() {
        return parentAreaId;
    }

    public void setParentAreaId(Integer parentAreaId) {
        this.parentAreaId = parentAreaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Area other = (Area) that;
        return (this.getAreaId() == null ? other.getAreaId() == null : this.getAreaId().equals(other.getAreaId()))
                && (this.getParentAreaId() == null ? other.getParentAreaId() == null : this.getParentAreaId().equals(other.getParentAreaId()))
                && (this.getAreaName() == null ? other.getAreaName() == null : this.getAreaName().equals(other.getAreaName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAreaId() == null) ? 0 : getAreaId().hashCode());
        result = prime * result + ((getParentAreaId() == null) ? 0 : getParentAreaId().hashCode());
        result = prime * result + ((getAreaName() == null) ? 0 : getAreaName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Area{" +
                "areaId=" + areaId +
                ", parentAreaId=" + parentAreaId +
                ", areaName='" + areaName + '\'' +
                '}';
    }
}