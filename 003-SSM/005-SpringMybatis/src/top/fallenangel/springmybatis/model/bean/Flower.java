package top.fallenangel.springmybatis.model.bean;

import java.io.Serializable;

/**
 * tb_flower
 * @author 
 */
public class Flower implements Serializable {
    private Integer fId;

    private String fName;

    private Double fPrice;

    private Integer cId;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public Double getfPrice() {
        return fPrice;
    }

    public void setfPrice(Double fPrice) {
        this.fPrice = fPrice;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
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
        Flower other = (Flower) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfName() == null ? other.getfName() == null : this.getfName().equals(other.getfName()))
            && (this.getfPrice() == null ? other.getfPrice() == null : this.getfPrice().equals(other.getfPrice()))
            && (this.getcId() == null ? other.getcId() == null : this.getcId().equals(other.getcId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfName() == null) ? 0 : getfName().hashCode());
        result = prime * result + ((getfPrice() == null) ? 0 : getfPrice().hashCode());
        result = prime * result + ((getcId() == null) ? 0 : getcId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fId=").append(fId);
        sb.append(", fName=").append(fName);
        sb.append(", fPrice=").append(fPrice);
        sb.append(", cId=").append(cId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}