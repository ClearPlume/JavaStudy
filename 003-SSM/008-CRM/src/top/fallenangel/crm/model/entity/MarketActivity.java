package top.fallenangel.crm.model.entity;

import org.springframework.format.annotation.DateTimeFormat;
import top.fallenangel.crm.template.impl.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * t_market_activity 活动表
 *
 * @author 坠天使
 */
public class MarketActivity extends BaseEntity implements Serializable {
    private Integer activityId;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 活动内容
     */
    private String activityContent;

    /**
     * 参与对象
     */
    private String activityPerson;

    /**
     * 活动地点
     */
    private String activityPlace;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date activityStartTime;

    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date activityEndTime;

    /**
     * 活动成本
     */
    private Double activityCost;

    private static final long serialVersionUID = 1L;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent;
    }

    public String getActivityPerson() {
        return activityPerson;
    }

    public void setActivityPerson(String activityPerson) {
        this.activityPerson = activityPerson;
    }

    public String getActivityPlace() {
        return activityPlace;
    }

    public void setActivityPlace(String activityPlace) {
        this.activityPlace = activityPlace;
    }

    public Date getActivityStartTime() {
        return activityStartTime;
    }

    public void setActivityStartTime(Date activityStartTime) {
        this.activityStartTime = activityStartTime;
    }

    public Date getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(Date activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    public Double getActivityCost() {
        return activityCost;
    }

    public void setActivityCost(Double activityCost) {
        this.activityCost = activityCost;
    }

    @Override
    public String toString() {
        return "MarketActivity{" +
                "activityId=" + activityId +
                ", activityName='" + activityName + '\'' +
                ", activityContent='" + activityContent + '\'' +
                ", activityPerson='" + activityPerson + '\'' +
                ", activityPlace='" + activityPlace + '\'' +
                ", activityStartTime=" + activityStartTime +
                ", activityEndTime=" + activityEndTime +
                ", activityCost=" + activityCost +
                '}' + super.toString();
    }
}