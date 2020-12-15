package top.fallenangel.activemq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.fallenangel.activemq.util.MessageProducer;

@SpringBootTest
class ActiveMQProducerApplicationTests {

	@Autowired
	private MessageProducer messageProducer;

	@Test
	void contextLoads() {
		messageProducer.send();
	}
}
