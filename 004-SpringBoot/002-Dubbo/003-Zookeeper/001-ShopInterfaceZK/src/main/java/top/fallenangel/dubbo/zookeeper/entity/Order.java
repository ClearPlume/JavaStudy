package top.fallenangel.dubbo.zookeeper.entity;

import java.io.Serializable;

public class Order implements Serializable {
    /**
     * 订单id
     */
    private String id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 订单价格
     */
    private Double price;
    /**
     * 订单数量
     */
    private Integer amount;

    public Order() {
    }

    public Order(String id, String name, Double price, Integer amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}