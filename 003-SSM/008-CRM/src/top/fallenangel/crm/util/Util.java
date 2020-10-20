package top.fallenangel.crm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    public static String dateFormat(Date date, String pattern) {
        return date == null ? "" : new SimpleDateFormat(pattern).format(date);
    }
}