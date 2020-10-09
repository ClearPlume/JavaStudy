package top.fallenangel;

import com.alibaba.fastjson.JSON;

public class JSONTest {
    public static void main(String[] args) {
        String json = "{\n" +
                "  \"state\": \"success\",\n" +
                "  \"code\": \"0\",\n" +
                "  \"data\": {\n" +
                "    \"acc\": 100,\n" +
                "    \"city\": \"北京市\",\n" +
                "    \"dist\": \"通州区\",\n" +
                "    \"addr\": \"北京市通州区永乐店镇北京金篮子生态种植有限公司\",\n" +
                "    \"prov\": \"北京市\",\n" +
                "    \"lon\": 116.82106018,\n" +
                "    \"number\": \"13\",\n" +
                "    \"town\": \"永乐店镇\",\n" +
                "    \"street\": \"永乐大街\",\n" +
                "    \"lat\": 39.69581985\n" +
                "  }\n" +
                "}";

        DataAccessed dataAccessed = JSON.parseObject(json, DataAccessed.class);
        System.out.println(dataAccessed);
        System.out.println("**************************************************");
        String s = JSON.toJSONString(dataAccessed, true);
        System.out.println(s);
    }
}