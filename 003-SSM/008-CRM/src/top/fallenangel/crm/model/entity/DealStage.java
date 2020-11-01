package top.fallenangel.crm.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import top.fallenangel.crm.template.impl.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * t_deal_stage 交易阶段
 *
 * @author 坠天使
 */
public class DealStage extends BaseEntity implements Serializable {
    private Integer stageId;

    /**
     * 所属交易id
     */
    private Integer dealId;

    /**
     * 阶段名称
     */
    private String stageName;

    /**
     * 是否当前阶段
     */
    private Boolean stageCurrent = false;

    /**
     * 阶段交易金额
     */
    private Double stageAmount;

    /**
     * 阶段预计成交日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date stagePlanTime;

    private static final long serialVersionUID = 1L;

    public Integer getStageId() {
        return stageId;
    }

    public void setStageId(Integer stageId) {
        this.stageId = stageId;
    }

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public Boolean getStageCurrent() {
        return stageCurrent;
    }

    public void setStageCurrent(Boolean stageCurrent) {
        this.stageCurrent = stageCurrent;
    }

    public Double getStageAmount() {
        return stageAmount;
    }

    public void setStageAmount(Double stageAmount) {
        this.stageAmount = stageAmount;
    }

    public Date getStagePlanTime() {
        return stagePlanTime;
    }

    public void setStagePlanTime(Date stagePlanTime) {
        this.stagePlanTime = stagePlanTime;
    }

    @Override
    public String toString() {
        return "DealStage{" +
                "stageId=" + stageId +
                ", dealId=" + dealId +
                ", stageName='" + stageName + '\'' +
                ", stageCurrent=" + stageCurrent +
                ", stageAmount=" + stageAmount +
                ", stagePlanTime=" + stagePlanTime +
                ", " + super.toString() +
                '}';
    }
}