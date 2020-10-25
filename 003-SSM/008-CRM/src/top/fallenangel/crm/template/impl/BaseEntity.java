package top.fallenangel.crm.template.impl;

import org.springframework.format.annotation.DateTimeFormat;
import top.fallenangel.crm.model.entity.Employee;

import java.util.Date;

public class BaseEntity {
    /**
     * 创建人
     */
    private Employee creator;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 修改人
     */
    private Employee updater;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public Employee getCreator() {
        return creator;
    }

    public void setCreator(Employee creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Employee getUpdater() {
        return updater;
    }

    public void setUpdater(Employee updater) {
        this.updater = updater;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "creator=" + creator +
                ", createTime=" + createTime +
                ", updater=" + updater +
                ", updateTime=" + updateTime +
                '}';
    }
}