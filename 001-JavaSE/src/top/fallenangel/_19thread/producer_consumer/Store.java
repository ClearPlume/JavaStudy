package top.fallenangel._19thread.producer_consumer;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private int curSize = 0;
    private final int capacity = 30;
    private final List<Goods> storage = new ArrayList<>(capacity);

    public boolean storageFull() {
        return curSize == capacity;
    }

    public boolean storageEmpty() {
        return curSize == 0;
    }

    public void produce() {
        Goods good = new Goods(curSize);
        storage.add(good);
        curSize++;
        System.out.println("生产者生产了货品：" + good + "，现有库存：" + curSize);
    }

    public void consume() {
        curSize--;
        Goods good = storage.remove(curSize);
        System.out.println("消费者消费了货品：" + good + "，现有库存：" + curSize);
    }
}