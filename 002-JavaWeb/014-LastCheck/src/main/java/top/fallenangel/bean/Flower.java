package top.fallenangel.bean;

public class Flower {
    private int f_id;
    private String f_name;
    private double f_price;
    private int c_id;

    public Flower() {
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

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "f_id=" + f_id +
                ", f_name='" + f_name + '\'' +
                ", f_price=" + f_price +
                ", c_id=" + c_id +
                '}';
    }
}