package top.fallenangel._19thread.producer_consumer_lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerLockTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Storage store = new Storage();

        new Thread(new Producer(lock, condition, store, 300)).start();
        new Thread(new Consumer(lock, condition, store, 500)).start();
    }
}