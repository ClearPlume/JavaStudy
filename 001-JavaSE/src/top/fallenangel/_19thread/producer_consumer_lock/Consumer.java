package top.fallenangel._19thread.producer_consumer_lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer implements Runnable {
    private final Lock lock;
    private final Condition condition;
    private final Storage store;
    private final int consumeSpeed;

    public Consumer(Lock lock, Condition condition, Storage store, int consumeSpeed) {
        this.lock = lock;
        this.condition = condition;
        this.store = store;
        this.consumeSpeed = consumeSpeed;
    }

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            lock.lock();
            try {
                //noinspection BusyWait
                Thread.sleep(consumeSpeed);
                if (store.storageEmpty()) {
                    System.out.println("消费者把库存消费完了");
                    condition.await();
                } else {
                    store.consume();
                    condition.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }
    }
}