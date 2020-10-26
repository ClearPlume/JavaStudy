package top.fallenangel.crm.model.entity;

import top.fallenangel.crm.template.impl.BaseEntity;

import java.io.Serializable;

/**
 * t_activity_remark 活动备注表
 *
 * @author 坠天使
 */
public class ActivityRemark extends BaseEntity implements Serializable {
    private Integer remarkId;

    /**
     * 活动id
     */
    private Integer activityId;

    /**
     * 备注标题
     */
    private String remarkTitle;

    /**
     * 备注内容
     */
    private String remarkContent;

    private static final long serialVersionUID = 1L;

    public Integer getRemarkId() {
        return remarkId;
    }

    public void setRemarkId(Integer remarkId) {
        this.remarkId = remarkId;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getRemarkTitle() {
        return remarkTitle;
    }

    public void setRemarkTitle(String remarkTitle) {
        this.remarkTitle = remarkTitle;
    }

    public void setRemarkContent(String remarkContent) {
        this.remarkContent = remarkContent;
    }

    public String getRemarkContent() {
        return remarkContent;
    }

    @Override
    public String toString() {
        return "ActivityRemark{" +
                "remarkId=" + remarkId +
                ", activityId=" + activityId +
                ", remarkTitle='" + remarkTitle + '\'' +
                ", remarkContent='" + remarkContent + '\'' +
                '}' + super.toString();
    }
}