package top.fallenangel;

public class DataAccessed {
    private String state;
    private int code;
    private Data data;

    public DataAccessed() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DataAccessed{" +
                "state='" + state + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}