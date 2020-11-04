package top.fallenangel.dubbo.main;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.fallenangel.dubbo.main.service.impl.ShopService;
import top.fallenangel.dubbo.order.entity.Order;

public class ShopApplication {
    @Test
    public void testShop() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("shop-consume.xml");

        ShopService shopService = applicationContext.getBean(ShopService.class);
        Order order = shopService.buyGoods(110, "剃须刀", 159D, 1);
        System.out.println("order = " + order);
    }
}