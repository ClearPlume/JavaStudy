package top.fallenangel._19thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    public static void main(String[] args) {
        FutureTask<String> task = new FutureTask<>(() -> {
            System.out.println("传输中...");
            Thread.sleep(2000);
            return "飞雪";
        });

        Thread t1 = new Thread(task);
        t1.start();

        try {
            System.out.println(task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}