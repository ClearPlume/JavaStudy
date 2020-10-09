package top.fallenangel.springtransaction.model.bean;

import java.io.Serializable;

/**
 * tb_account
 * @author 
 */
public class Account implements Serializable {
    /**
     * 账户id
     */
    private Integer aId;

    /**
     * 帐户名称
     */
    private String aName;

    /**
     * 帐户余额
     */
    private Integer aAmount;

    private static final long serialVersionUID = 1L;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public Integer getaAmount() {
        return aAmount;
    }

    public void setaAmount(Integer aAmount) {
        this.aAmount = aAmount;
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
        Account other = (Account) that;
        return (this.getaId() == null ? other.getaId() == null : this.getaId().equals(other.getaId()))
            && (this.getaName() == null ? other.getaName() == null : this.getaName().equals(other.getaName()))
            && (this.getaAmount() == null ? other.getaAmount() == null : this.getaAmount().equals(other.getaAmount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getaId() == null) ? 0 : getaId().hashCode());
        result = prime * result + ((getaName() == null) ? 0 : getaName().hashCode());
        result = prime * result + ((getaAmount() == null) ? 0 : getaAmount().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", aId=").append(aId);
        sb.append(", aName=").append(aName);
        sb.append(", aAmount=").append(aAmount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}