package top.fallenangel._19thread.producer_consumer;

public class Producer implements Runnable {
    private final Store store;
    private final int produceSpeed;

    public Producer(Store store, int produceSpeed) {
        this.store = store;
        this.produceSpeed = produceSpeed;
    }

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            synchronized (store) {
                try {
                    //noinspection BusyWait
                    Thread.sleep(produceSpeed);
                    if (store.storageFull()) {
                        System.out.println("生产者生产满库存了");
                        store.wait();
                    } else {
                        store.produce();
                        store.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}