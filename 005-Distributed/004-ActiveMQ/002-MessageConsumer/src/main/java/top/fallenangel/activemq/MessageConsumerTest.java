package top.fallenangel.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MessageConsumerTest {

    private static final String MQ_URL = "tcp://192.168.137.201:61616";
    private static final String QUEUE_NAME = "Queue 001";

    public static void main(String[] args) throws JMSException {

        // 创建连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(MQ_URL);

        // 创建并启动连接
        Connection connection = connectionFactory.createConnection();
        connection.start();

        // 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 创建目的地
        Queue queue = session.createQueue(QUEUE_NAME);

        // 创建消息消费者
        MessageConsumer messageConsumer = session.createConsumer(queue);

        // 接收消息
        Message message;

        while ((message = messageConsumer.receive(1000)) != null) {
            TextMessage textMessage = (TextMessage) message;
            System.out.println("textMessage = " + textMessage.getText());
        }

        System.out.println("消息接收完毕");

        // 关闭资源
        messageConsumer.close();
        session.close();
        connection.close();
    }
}
