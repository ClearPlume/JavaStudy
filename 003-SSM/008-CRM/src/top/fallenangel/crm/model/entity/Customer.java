package top.fallenangel.crm.model.entity;

import top.fallenangel.crm.template.impl.BaseEntity;

import java.io.Serializable;

/**
 * t_customer 客户
 *
 * @author 坠天使
 */
public class Customer extends BaseEntity implements Serializable {
    private Integer customerId;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 公司网站
     */
    private String customerNet;

    /**
     * 公司座机
     */
    private String customerPhone;

    /**
     * 公司地址
     */
    private String customerAddress;

    /**
     * 客户描述
     */
    private String costumerDescription;

    /**
     * 客户星级
     */
    private Integer costumerStar;

    private static final long serialVersionUID = 1L;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNet() {
        return customerNet;
    }

    public void setCustomerNet(String customerNet) {
        this.customerNet = customerNet;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCostumerDescription() {
        return costumerDescription;
    }

    public void setCostumerDescription(String costumerDescription) {
        this.costumerDescription = costumerDescription;
    }

    public Integer getCostumerStar() {
        return costumerStar;
    }

    public void setCostumerStar(Integer costumerStar) {
        this.costumerStar = costumerStar;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerNet='" + customerNet + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", costumerDescription='" + costumerDescription + '\'' +
                ", costumerStar=" + costumerStar +
                ", " + super.toString() +
                '}';
    }
}