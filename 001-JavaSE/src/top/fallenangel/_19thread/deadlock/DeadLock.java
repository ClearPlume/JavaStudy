package top.fallenangel._19thread.deadlock;

public class DeadLock implements Runnable {
    private final Object l1 = new Object();
    private final Object l2 = new Object();
    private int flag = 1;

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            switch (flag) {
                case 1:
                    synchronized (l1) {
                        System.out.println("线程" + Thread.currentThread().getName() + "获得l1锁");
                        synchronized (l2) {
                            System.out.println("线程" + Thread.currentThread().getName() + "获得l2锁");
                            flag = 2;
                        }
                    }
                    break;
                case 2:
                    synchronized (l2) {
                        System.out.println("线程" + Thread.currentThread().getName() + "获得l2锁");
                        synchronized (l1) {
                            System.out.println("线程" + Thread.currentThread().getName() + "获得l1锁");
                            flag = 1;
                        }
                    }
                    break;
            }
        }
    }
}