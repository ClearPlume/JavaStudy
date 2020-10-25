package top.fallenangel.crm.model.entity;

import org.springframework.format.annotation.DateTimeFormat;
import top.fallenangel.crm.template.impl.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * t_employee 员工表
 *
 * @author 坠天使
 */
public class Employee extends BaseEntity implements Serializable {
    private Integer employeeId;

    /**
     * 员工所在部门
     */
    private Dept dept;

    /**
     * 员工工号，用户名
     */
    private String employeeNo;

    /**
     * 密码
     */
    private String employeePwd;

    /**
     * 员工姓名
     */
    private String employeeName;

    /**
     * 员工性别
     */
    private String employeeSex;

    /**
     * 员工年龄
     */
    private Integer employeeAge;

    /**
     * 员工手机号
     */
    private String employeePhone;

    /**
     * 身份证号
     */
    private String employeeCardNo;

    /**
     * 邮箱
     */
    private String employeeMail;

    /**
     * 生日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date employeeBirthday;

    /**
     * 职位
     */
    private String employeeJob;

    /**
     * 家庭住址
     */
    private String employeeAddress;

    /**
     * 员工失效日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date employeeExpireTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
     * 状态(0 离职，1 在职)
     */
    private Integer employeeStatus;

    /**
     * 允许登录ip
     */
    private String employeeAllowedIps;

    /**
     * 传递错误信息
     */
    private String msg;

    private static final long serialVersionUID = 1L;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getEmployeePwd() {
        return employeePwd;
    }

    public void setEmployeePwd(String employeePwd) {
        this.employeePwd = employeePwd;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSex() {
        return employeeSex;
    }

    public void setEmployeeSex(String employeeSex) {
        this.employeeSex = employeeSex;
    }

    public Integer getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(Integer employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeCardNo() {
        return employeeCardNo;
    }

    public void setEmployeeCardNo(String employeeCardNo) {
        this.employeeCardNo = employeeCardNo;
    }

    public String getEmployeeMail() {
        return employeeMail;
    }

    public void setEmployeeMail(String employeeMail) {
        this.employeeMail = employeeMail;
    }

    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(Date employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeJob() {
        return employeeJob;
    }

    public void setEmployeeJob(String employeeJob) {
        this.employeeJob = employeeJob;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Date getEmployeeExpireTime() {
        return employeeExpireTime;
    }

    public void setEmployeeExpireTime(Date employeeExpireTime) {
        this.employeeExpireTime = employeeExpireTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(Integer employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getEmployeeAllowedIps() {
        return employeeAllowedIps;
    }

    public void setEmployeeAllowedIps(String employeeAllowedIps) {
        this.employeeAllowedIps = employeeAllowedIps;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", dept=" + dept +
                ", employeeNo='" + employeeNo + '\'' +
                ", employeePwd='" + employeePwd + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSex='" + employeeSex + '\'' +
                ", employeeAge=" + employeeAge +
                ", employeePhone='" + employeePhone + '\'' +
                ", employeeCardNo='" + employeeCardNo + '\'' +
                ", employeeMail='" + employeeMail + '\'' +
                ", employeeBirthday=" + employeeBirthday +
                ", employeeJob='" + employeeJob + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", employeeExpireTime=" + employeeExpireTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", employeeStatus=" + employeeStatus +
                ", employeeAllowedIps='" + employeeAllowedIps + '\'' +
                ", msg='" + msg + '\'' +
                '}' + super.toString();
    }
}