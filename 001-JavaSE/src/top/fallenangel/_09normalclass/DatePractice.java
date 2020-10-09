package top.fallenangel._09normalclass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class DatePractice {
    public static void main(String[] args) {
        Date date1 = new Date(1596274074294L);
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分ss秒 SSS毫秒 星期u");
        System.out.println(format.format(date1));
        Date date2 = null;
        try {
            date2 = format.parse("2020年08月02日 19点30分20秒 556毫秒 星期7");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(format.format(date2));

        long divMilliseconds = Objects.requireNonNull(date2).getTime() - date1.getTime();
        System.out.println(divMilliseconds / 1000D / 60 / 60);
    }
}