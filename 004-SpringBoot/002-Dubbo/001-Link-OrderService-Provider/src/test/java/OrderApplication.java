import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class OrderApplication {
    @Test
    public void testOrder() throws IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("order-service-provider.xml");

        System.in.read();
    }
}