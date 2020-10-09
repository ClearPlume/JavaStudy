package top.fallenangel._19thread.daemon;

public class AssistantTest {
    public static void main(String[] args) {
        Shooter shooter = new Shooter();
        Thread t1 = new Thread(shooter);
        Thread t2 = new Thread(new Assistant(shooter));

        t2.setDaemon(true);

        t1.start();
        t2.start();
    }
}