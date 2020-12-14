package top.fallenangel.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 练习消息队列生产者
 */
public class MessageProducerTest {
    private static final String MQ_URL = "tcp://192.168.137.201:61616";
    private static final String TOPIC_NAME = "Topic 001";

    public static void main(String[] args) throws JMSException {

        // 创建连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(MQ_URL);

        // 创建并启动连接
        Connection connection = connectionFactory.createConnection();
        connection.start();

        // 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 创建目的地
        Topic topic = session.createTopic(TOPIC_NAME);

        // 创建消息生产者
        MessageProducer producer = session.createProducer(topic);

        for (int i = 1; i <= 3; i++) {
            // 创建并发送消息
            producer.send(session.createTextMessage("Msg --> " + i));
        }

        System.out.println("消息发送完毕");

        // 关闭资源
        producer.close();
        session.close();
        connection.close();
    }
}
