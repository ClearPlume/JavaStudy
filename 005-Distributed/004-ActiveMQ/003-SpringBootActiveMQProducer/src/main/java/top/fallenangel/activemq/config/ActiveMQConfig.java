package top.fallenangel.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

@Configuration
public class ActiveMQConfig {

    @Value("${spring.activemq.dest}")
    private String queueName;

    @Bean
    public Queue createQueue() {
        return new ActiveMQQueue(queueName);
    }
}
