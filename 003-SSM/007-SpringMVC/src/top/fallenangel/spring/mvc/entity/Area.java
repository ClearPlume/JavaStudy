package top.fallenangel.spring.mvc.entity;

import java.io.Serializable;

/**
 * t_area 区域表
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
}