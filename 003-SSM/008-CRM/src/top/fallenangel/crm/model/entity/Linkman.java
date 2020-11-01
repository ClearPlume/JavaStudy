package top.fallenangel.crm.model.entity;

import org.springframework.format.annotation.DateTimeFormat;
import top.fallenangel.crm.template.impl.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * t_linkman 联系人
 *
 * @author 坠天使
 */
public class Linkman extends BaseEntity implements Serializable {
    private Integer linkmanId;

    /**
     * 客户
     */
    private Customer customer;

    /**
     * 联系人姓名
     */
    private String linkmanName;

    /**
     * 联系人性别
     */
    private Boolean linkmanSex;

    /**
     * 联系人年龄
     */
    private Integer linkmanAge;

    /**
     * 联系人职务
     */
    private String linkmanJob;

    /**
     * 称呼
     */
    private Integer appellation;

    /**
     * 联系人部门
     */
    private String linkmanDept;

    /**
     * 联系人座机
     */
    private String linkmanPhone;

    /**
     * 联系人手机
     */
    private String linkmanMobilePhone;

    /**
     * 联系人邮箱
     */
    private String linkmanMail;

    /**
     * 联系人地址
     */
    private String linkmanAddress;

    /**
     * 联系人生日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date linkmanBirthday;

    /**
     * 下次联系时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date linkmanNextDate;

    /**
     * 备注
     */
    private String linkmanRemark;

    private static final long serialVersionUID = 1L;

    public Integer getLinkmanId() {
        return linkmanId;
    }

    public void setLinkmanId(Integer linkmanId) {
        this.linkmanId = linkmanId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getLinkmanName() {
        return linkmanName;
    }

    public void setLinkmanName(String linkmanName) {
        this.linkmanName = linkmanName;
    }

    public Boolean getLinkmanSex() {
        return linkmanSex;
    }

    public void setLinkmanSex(Boolean linkmanSex) {
        this.linkmanSex = linkmanSex;
    }

    public Integer getLinkmanAge() {
        return linkmanAge;
    }

    public void setLinkmanAge(Integer linkmanAge) {
        this.linkmanAge = linkmanAge;
    }

    public String getLinkmanJob() {
        return linkmanJob;
    }

    public void setLinkmanJob(String linkmanJob) {
        this.linkmanJob = linkmanJob;
    }

    public Integer getAppellation() {
        return appellation;
    }

    public void setAppellation(Integer appellation) {
        this.appellation = appellation;
    }

    public String getLinkmanDept() {
        return linkmanDept;
    }

    public void setLinkmanDept(String linkmanDept) {
        this.linkmanDept = linkmanDept;
    }

    public String getLinkmanPhone() {
        return linkmanPhone;
    }

    public void setLinkmanPhone(String linkmanPhone) {
        this.linkmanPhone = linkmanPhone;
    }

    public String getLinkmanMobilePhone() {
        return linkmanMobilePhone;
    }

    public void setLinkmanMobilePhone(String linkmanMobilePhone) {
        this.linkmanMobilePhone = linkmanMobilePhone;
    }

    public String getLinkmanMail() {
        return linkmanMail;
    }

    public void setLinkmanMail(String linkmanMail) {
        this.linkmanMail = linkmanMail;
    }

    public String getLinkmanAddress() {
        return linkmanAddress;
    }

    public void setLinkmanAddress(String linkmanAddress) {
        this.linkmanAddress = linkmanAddress;
    }

    public Date getLinkmanBirthday() {
        return linkmanBirthday;
    }

    public void setLinkmanBirthday(Date linkmanBirthday) {
        this.linkmanBirthday = linkmanBirthday;
    }

    public Date getLinkmanNextDate() {
        return linkmanNextDate;
    }

    public void setLinkmanNextDate(Date linkmanNextDate) {
        this.linkmanNextDate = linkmanNextDate;
    }

    public String getLinkmanRemark() {
        return linkmanRemark;
    }

    public void setLinkmanRemark(String linkmanRemark) {
        this.linkmanRemark = linkmanRemark;
    }

    @Override
    public String toString() {
        return "Linkman{" +
                "linkmanId=" + linkmanId +
                ", customer=" + customer +
                ", linkmanName='" + linkmanName + '\'' +
                ", linkmanSex=" + linkmanSex +
                ", linkmanAge=" + linkmanAge +
                ", linkmanJob='" + linkmanJob + '\'' +
                ", appellation=" + appellation +
                ", linkmanDept='" + linkmanDept + '\'' +
                ", linkmanPhone='" + linkmanPhone + '\'' +
                ", linkmanMobilePhone='" + linkmanMobilePhone + '\'' +
                ", linkmanMail='" + linkmanMail + '\'' +
                ", linkmanAddress='" + linkmanAddress + '\'' +
                ", linkmanBirthday=" + linkmanBirthday +
                ", linkmanNextDate=" + linkmanNextDate +
                ", linkmanRemark='" + linkmanRemark + '\'' +
                ", " + super.toString() +
                '}';
    }
}