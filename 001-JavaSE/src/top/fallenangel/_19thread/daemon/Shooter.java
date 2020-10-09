package top.fallenangel._19thread.daemon;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Shooter implements Runnable {
    private final Random random;
    private int hp;
    private Timer timer;

    public Shooter() {
        random = new Random();
        hp = 5000;
    }

    public int getHp() {
        return hp;
    }

    public void addHp(int hp) {
        this.hp = this.hp + hp;
    }

    @Override
    public void run() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                down();
            }
        }, 0, 500);
    }

    private void down() {
        if (hp > 0) {
            hp = hp - random.nextInt(750);
            System.out.println("HP：" + hp);
        } else {
            timer.cancel();
        }
    }
}