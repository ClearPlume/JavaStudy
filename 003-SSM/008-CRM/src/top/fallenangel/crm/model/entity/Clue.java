package top.fallenangel.crm.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import top.fallenangel.crm.template.impl.BaseEntity;

import java.io.Serializable;

/**
 * t_clue 线索
 *
 * @author 坠天使
 */
public class Clue extends BaseEntity implements Serializable {
    private Integer clueId;

    private MarketActivity activity;

    /**
     * 线索名称
     */
    private String clueTitle;

    /**
     * 线索内容
     */
    @JsonIgnore
    private String clueContent;

    /**
     * 线索提供人姓名
     */
    private String clueProviderName;

    /**
     * 线索提供人电话
     */
    @JsonIgnore
    private String clueProviderMobilePhone;

    /**
     * 线索意向人姓名
     */
    private String clueIntentionPerson;

    /**
     * 线索意向人手机号
     */
    @JsonIgnore
    private String clueIntentionMobilePhone;

    /**
     * 线索意向人座机号码
     */
    @JsonIgnore
    private String clueIntentionPhone;

    /**
     * 线索意向人邮箱
     */
    @JsonIgnore
    private String clueIntentionMail;

    /**
     * 线索意向人职位
     */
    @JsonIgnore
    private String clueIntentionJob;

    /**
     * 线索意向人公司
     */
    @JsonIgnore
    private String clueIntentionCompany;

    /**
     * 线索意向人公司网站
     */
    @JsonIgnore
    private String clueIntentionCompanySite;

    /**
     * 线索意向人公司地址
     */
    @JsonIgnore
    private String clueIntentionCompanyAddress;

    /**
     * 线索状态
     */
    @JsonIgnore
    private Integer clueStatus;

    /**
     * 线索来源
     */
    @JsonIgnore
    private Integer clueSource;

    private static final long serialVersionUID = 1L;

    public Integer getClueId() {
        return clueId;
    }

    public void setClueId(Integer clueId) {
        this.clueId = clueId;
    }

    public MarketActivity getActivity() {
        return activity;
    }

    public void setActivity(MarketActivity activity) {
        this.activity = activity;
    }

    public String getClueTitle() {
        return clueTitle;
    }

    public void setClueTitle(String clueTitle) {
        this.clueTitle = clueTitle;
    }

    public String getClueContent() {
        return clueContent;
    }

    public void setClueContent(String clueContent) {
        this.clueContent = clueContent;
    }

    public String getClueProviderName() {
        return clueProviderName;
    }

    public void setClueProviderName(String clueProviderName) {
        this.clueProviderName = clueProviderName;
    }

    public String getClueProviderMobilePhone() {
        return clueProviderMobilePhone;
    }

    public void setClueProviderMobilePhone(String clueProviderMobilePhone) {
        this.clueProviderMobilePhone = clueProviderMobilePhone;
    }

    public String getClueIntentionPerson() {
        return clueIntentionPerson;
    }

    public void setClueIntentionPerson(String clueIntentionPerson) {
        this.clueIntentionPerson = clueIntentionPerson;
    }

    public String getClueIntentionMobilePhone() {
        return clueIntentionMobilePhone;
    }

    public void setClueIntentionMobilePhone(String clueIntentionMobilePhone) {
        this.clueIntentionMobilePhone = clueIntentionMobilePhone;
    }

    public String getClueIntentionPhone() {
        return clueIntentionPhone;
    }

    public void setClueIntentionPhone(String clueIntentionPhone) {
        this.clueIntentionPhone = clueIntentionPhone;
    }

    public String getClueIntentionMail() {
        return clueIntentionMail;
    }

    public void setClueIntentionMail(String clueIntentionMail) {
        this.clueIntentionMail = clueIntentionMail;
    }

    public String getClueIntentionJob() {
        return clueIntentionJob;
    }

    public void setClueIntentionJob(String clueIntentionJob) {
        this.clueIntentionJob = clueIntentionJob;
    }

    public String getClueIntentionCompany() {
        return clueIntentionCompany;
    }

    public void setClueIntentionCompany(String clueIntentionCompany) {
        this.clueIntentionCompany = clueIntentionCompany;
    }

    public String getClueIntentionCompanySite() {
        return clueIntentionCompanySite;
    }

    public void setClueIntentionCompanySite(String clueIntentionCompanySite) {
        this.clueIntentionCompanySite = clueIntentionCompanySite;
    }

    public String getClueIntentionCompanyAddress() {
        return clueIntentionCompanyAddress;
    }

    public void setClueIntentionCompanyAddress(String clueIntentionCompanyAddress) {
        this.clueIntentionCompanyAddress = clueIntentionCompanyAddress;
    }

    public Integer getClueStatus() {
        return clueStatus;
    }

    public void setClueStatus(Integer clueStatus) {
        this.clueStatus = clueStatus;
    }

    public Integer getClueSource() {
        return clueSource;
    }

    public void setClueSource(Integer clueSource) {
        this.clueSource = clueSource;
    }

    @Override
    public String toString() {
        return "Clue{" +
                "clueId=" + clueId +
                ", activity=" + activity +
                ", clueTitle='" + clueTitle + '\'' +
                ", clueContent='" + clueContent + '\'' +
                ", clueProviderName='" + clueProviderName + '\'' +
                ", clueProviderMobilePhone='" + clueProviderMobilePhone + '\'' +
                ", clueIntentionPerson='" + clueIntentionPerson + '\'' +
                ", clueIntentionMobilePhone='" + clueIntentionMobilePhone + '\'' +
                ", clueIntentionPhone='" + clueIntentionPhone + '\'' +
                ", clueIntentionMail='" + clueIntentionMail + '\'' +
                ", clueIntentionJob='" + clueIntentionJob + '\'' +
                ", clueIntentionCompany='" + clueIntentionCompany + '\'' +
                ", clueIntentionCompanySite='" + clueIntentionCompanySite + '\'' +
                ", clueIntentionCompanyAddress='" + clueIntentionCompanyAddress + '\'' +
                ", clueStatus=" + clueStatus +
                ", clueSource=" + clueSource +
                ", " + super.toString() +
                '}';
    }
}