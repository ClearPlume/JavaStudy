package top.fallenangel._19thread;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        final int[] count = {1};

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(count[0]++);
            }
        }, 0, 300);

        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        timer.cancel();
    }
}