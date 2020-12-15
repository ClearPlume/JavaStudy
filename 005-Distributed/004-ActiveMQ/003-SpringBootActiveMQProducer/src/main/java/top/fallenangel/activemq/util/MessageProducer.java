package top.fallenangel.activemq.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Topic;
import java.util.UUID;

@Component
public class MessageProducer {

    @Autowired
    private Topic topic;

    @Autowired
    private JmsMessagingTemplate messaging;

    public void send() {
        messaging.convertAndSend(topic, UUID.randomUUID().toString());
    }

    @Scheduled(fixedDelay = 3000L)
    public void timedSend() {
        messaging.convertAndSend(topic, UUID.randomUUID().toString());
    }
}
