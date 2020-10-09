package top.fallenangel._19thread.deadlock;

public class DeadLockTest {
    public static void main(String[] args) {
        DeadLock lock = new DeadLock();

        Thread t1 = new Thread(lock, "T1");
        Thread t2 = new Thread(lock, "T2");

        t1.start();
        t2.start();
    }
}