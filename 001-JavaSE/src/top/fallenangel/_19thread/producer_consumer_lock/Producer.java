package top.fallenangel._19thread.producer_consumer_lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable {
    private final Lock lock;
    private final Condition condition;
    private final Storage store;
    private final int produceSpeed;

    public Producer(Lock lock, Condition condition, Storage store, int produceSpeed) {
        this.lock = lock;
        this.condition = condition;
        this.store = store;
        this.produceSpeed = produceSpeed;
    }

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            lock.lock();
            try {
                //noinspection BusyWait
                Thread.sleep(produceSpeed);
                if (store.storageFull()) {
                    System.out.println("生产者生产满库存了");
                    condition.await();
                } else {
                    store.produce();
                    condition.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }
    }
}