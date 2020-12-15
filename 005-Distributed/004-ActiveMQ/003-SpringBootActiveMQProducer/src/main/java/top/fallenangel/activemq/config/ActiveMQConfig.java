package top.fallenangel.activemq.config;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Topic;

@Configuration
public class ActiveMQConfig {

    @Value("${spring.activemq.dest}")
    private String queueName;

    @Bean
    public Topic createQueue() {
        return new ActiveMQTopic(queueName);
    }
}
