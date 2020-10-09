package top.fallenangel._19thread;

public class Runner implements Runnable {
    private final String name;
    private int current = 0;
    private final int dis;
    private final int step;

    public Runner(String name, int dis) {
        this.name = name;
        this.dis = dis;
        this.step = 10;
    }

    private void running() {
        while (current < dis) {
            current = current + step;
            System.out.println(name + "跑了" + step + "米， 当前：" + current + "米");
        }
        System.out.println(name + "跑完了");
    }

    @Override
    public void run() {
        running();
    }
}