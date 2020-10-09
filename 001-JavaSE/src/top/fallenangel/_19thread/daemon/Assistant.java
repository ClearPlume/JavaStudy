package top.fallenangel._19thread.daemon;

import java.util.Timer;
import java.util.TimerTask;

public class Assistant implements Runnable {
    private final Shooter shooter;

    public Assistant(Shooter shooter) {
        this.shooter = shooter;
    }

    @Override
    public void run() {
        startDaemon();
    }

    private void startDaemon() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (shooter.getHp() <= 2000) {
                    shooter.addHp(2000);
                    System.out.println("续命2000！");
                }
            }
        }, 0, 1000 * 2);
    }
}
