package top.fallenangel._19thread;

public class ThreadTest {
    public static void main(String[] args) {
        Thread bolt = new Thread(new Runner("博尔特", 100));
        Thread lewes = new Thread(new Runner("刘易斯", 100));

        bolt.start();
        lewes.start();
    }
}