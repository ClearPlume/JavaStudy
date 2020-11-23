package top.fallenangel.springboot.p2p.model.vo;

public class NameValuePair {
    private String name;
    private Double value;

    public NameValuePair() {
    }

    public NameValuePair(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
