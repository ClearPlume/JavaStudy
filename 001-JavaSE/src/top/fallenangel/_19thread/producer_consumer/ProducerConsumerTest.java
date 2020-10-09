package top.fallenangel._19thread.producer_consumer;

public class ProducerConsumerTest {
    public static void main(String[] args) {
        Store store = new Store();
        Thread producer = new Thread(new Producer(store, 300), "生产者");
        Thread consumer = new Thread(new Consumer(store, 500), "消费者");

        producer.start();
        consumer.start();
    }
}