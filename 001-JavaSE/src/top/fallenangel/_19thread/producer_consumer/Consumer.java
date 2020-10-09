package top.fallenangel._19thread.producer_consumer;

public class Consumer implements Runnable {
    private final Store store;
    private final int consumeSpeed;

    public Consumer(Store store, int consumeSpeed) {
        this.store = store;
        this.consumeSpeed = consumeSpeed;
    }

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            synchronized (store) {
                try {
                    //noinspection BusyWait
                    Thread.sleep(consumeSpeed);
                    if (store.storageEmpty()) {
                        System.out.println("消费者把库存消费完了");
                        store.wait();
                    } else {
                        store.consume();
                        store.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}