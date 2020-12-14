package top.fallenangel.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.TimeUnit;

public class MessageConsumerTest {

    private static final String MQ_URL = "tcp://192.168.137.201:61616";
    private static final String TOPIC_NAME = "Topic 001";

    public static void main(String[] args) throws Exception {

        // 创建连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(MQ_URL);

        // 创建并启动连接
        Connection connection = connectionFactory.createConnection();
        connection.start();

        // 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 创建目的地
        Topic topic = session.createTopic(TOPIC_NAME);

        // 创建消息消费者
        MessageConsumer messageConsumer = session.createConsumer(topic);

        // 接收消息
        messageConsumer.setMessageListener(message -> {
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("textMessage = " + textMessage.getText());
                }
                catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        TimeUnit.MINUTES.sleep(3);

        System.out.println("消息接收完毕");

        // 关闭资源
        messageConsumer.close();
        session.close();
        connection.close();
    }
}
