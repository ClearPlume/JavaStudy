package top.fallenangel._20properties;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        properties.load(new InputStreamReader(PropertiesTest.class.getResourceAsStream("info.properties"), StandardCharsets.UTF_8));

        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        /*properties.put("name", "phoenix");
        properties.setProperty("age", "22");
        properties.setProperty("sex", "女");

        properties.store(new FileWriter("E:/_PowerNodeStudy/_测试代码/02-JavaSE/IDEA-Projects/02-JavaSE/src/top/fallenangel/_20properties/info.properties", StandardCharsets.UTF_8), "个人信息");*/
    }
}