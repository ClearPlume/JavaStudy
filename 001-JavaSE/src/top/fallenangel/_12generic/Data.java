package top.fallenangel._12generic;

public class Data<T extends Number> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}