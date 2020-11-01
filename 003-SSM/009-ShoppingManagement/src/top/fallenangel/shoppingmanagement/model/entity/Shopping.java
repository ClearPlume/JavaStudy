package top.fallenangel.shoppingmanagement.model.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * t_shopping 商品
 *
 * @author 坠天使
 */
public class Shopping implements Serializable {
    private Integer shoppingId;

    /**
     * 商品编号
     */
    private String shoppingNo;

    /**
     * 商品名称
     */
    private String shoppingName;

    /**
     * 商品规格
     */
    private String shoppingSpec;

    /**
     * 商品价格(元)
     */
    private Double shoppingPrice;

    /**
     * 商品产地
     */
    private String shoppingOrigin;

    /**
     * 上架时间
     */
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date shoppingShelfDate;

    /**
     * 商品已上架/下架
     */
    private Boolean shoppingStatus;

    private static final long serialVersionUID = 1L;

    public Integer getShoppingId() {
        return shoppingId;
    }

    public void setShoppingId(Integer shoppingId) {
        this.shoppingId = shoppingId;
    }

    public String getShoppingNo() {
        return shoppingNo;
    }

    public void setShoppingNo(String shoppingNo) {
        this.shoppingNo = shoppingNo;
    }

    public String getShoppingName() {
        return shoppingName;
    }

    public void setShoppingName(String shoppingName) {
        this.shoppingName = shoppingName;
    }

    public String getShoppingSpec() {
        return shoppingSpec;
    }

    public void setShoppingSpec(String shoppingSpec) {
        this.shoppingSpec = shoppingSpec;
    }

    public Double getShoppingPrice() {
        return shoppingPrice;
    }

    public void setShoppingPrice(Double shoppingPrice) {
        this.shoppingPrice = shoppingPrice;
    }

    public String getShoppingOrigin() {
        return shoppingOrigin;
    }

    public void setShoppingOrigin(String shoppingOrigin) {
        this.shoppingOrigin = shoppingOrigin;
    }

    public Date getShoppingShelfDate() {
        return shoppingShelfDate;
    }

    public void setShoppingShelfDate(Date shoppingShelfDate) {
        this.shoppingShelfDate = shoppingShelfDate;
    }

    public Boolean getShoppingStatus() {
        return shoppingStatus;
    }

    public void setShoppingStatus(Boolean shoppingStatus) {
        this.shoppingStatus = shoppingStatus;
    }
}