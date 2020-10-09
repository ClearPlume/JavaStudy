package top.fallenangel.springmybatis.model.bean;

public class FlowerVO {
    private String cName;
    private Integer minPrice;
    private Integer maxPrice;

    public FlowerVO(String cName, Integer minPrice, Integer maxPrice) {
        this.cName = cName;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Integer getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Integer minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Integer maxPrice) {
        this.maxPrice = maxPrice;
    }
}