package top.fallenangel._16map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapPractice {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        System.out.println("存asd：" + map.put("asd", 546));
        System.out.println("存jkl：" + map.put("jkl", 789));
        System.out.println("存fgh：" + map.put("fgh", 456));
        System.out.println("存asd：" + map.put("asd", 123));

        for (String key : map.keySet()) {
            System.out.println("key: " + key);
        }

        for (Integer value : map.values()) {
            System.out.println("value: " + value);
        }

        for (Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("删除asd：" + map.remove("asd"));

        System.out.println(map);
    }
 }