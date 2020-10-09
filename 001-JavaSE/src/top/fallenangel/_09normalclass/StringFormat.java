package top.fallenangel._09normalclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringFormat {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = null;
        try {
            date = format.parse("2020-08-01 15:35:20");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.printf("%s访问了%s，操作类型是%s，操作时间是:%tF %tT，操作的IP是:%s%n", "admin", "C:\\a.txt", "访问", date, date, "127.0.0.1");
        System.out.printf("%s修改了%s，原先的内容是:%s，修改后的内容是:%s%n", "admin", "C:\\a.txt", "HelloWorld", "HelloPowerNode");
        //noinspection RedundantStringFormatCall
        System.out.println(String.format("%s删除了%s，原先的文件备份在了%s，操作时间是:%tF %tT，操作的IP是:%s", "admin", "C:\\a.txt", "C:\\Windows\\a.txt", date, date, "127.0.0.1"));
    }
}