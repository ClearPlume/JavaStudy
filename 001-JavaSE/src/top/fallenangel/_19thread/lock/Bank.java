package top.fallenangel._19thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    private int balance;
    private final Lock lock;

    public Bank() {
        balance = 1000;
        lock = new ReentrantLock();
    }

    //    public synchronized void deductBalance(int balance) {
    public void deductBalance(int balance) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //        synchronized (this)
        lock.lock();
        this.balance = this.balance - balance;
        lock.unlock();
    }

    @Override
    public String toString() {
        return "Bank balance：{" + "balance='" + balance + '\'' + '}';
    }
}