package top.fallenangel._19thread.producer_consumer_lock;

public class Goods {
    private final String name;

    public Goods(int no) {
        name = "货品名称：" + no;
    }

    @Override
    public String toString() {
        return name;
    }
}