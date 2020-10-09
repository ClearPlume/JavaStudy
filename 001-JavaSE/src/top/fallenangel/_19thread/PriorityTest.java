package top.fallenangel._19thread;

public class PriorityTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " == " + i);
                // Thread.yield();
            }
        }, "T1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " == " + i);
            }
        }, "T2");

        t2.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        // t1.join();
        t2.start();
    }
}