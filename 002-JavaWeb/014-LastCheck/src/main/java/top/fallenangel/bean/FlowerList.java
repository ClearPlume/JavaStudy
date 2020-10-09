package top.fallenangel.bean;

public class FlowerList {
    private int f_id;
    private String f_name;
    private double f_price;
    private String c_name;

    public FlowerList() {
    }

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public double getF_price() {
        return f_price;
    }

    public void setF_price(double f_price) {
        this.f_price = f_price;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    @Override
    public String toString() {
        return "FlowerList{" +
                "f_id=" + f_id +
                ", f_name='" + f_name + '\'' +
                ", f_price=" + f_price +
                ", c_name='" + c_name + '\'' +
                '}';
    }
}