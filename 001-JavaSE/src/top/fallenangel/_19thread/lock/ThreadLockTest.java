package top.fallenangel._19thread.lock;

public class ThreadLockTest {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Thread t1 = new Thread(() -> bank.deductBalance(100));
        Thread t2 = new Thread(() -> bank.deductBalance(100));

        t1.start();
        t2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(bank);
    }
}