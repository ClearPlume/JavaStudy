package top.fallenangel.util;

import java.lang.reflect.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

public class BeanUtil {
    public static <V> void populate(Object obj, Map<String, V> properties) {
        Class<?> objClass = obj.getClass();

        for (Field field : objClass.getDeclaredFields()) {
            if (properties.containsKey(field.getName())) {
                try {
                    String setFieldName = "set" + field.getName().replaceFirst("\\w", field.getName().substring(0, 1).toUpperCase());
                    Method setField = objClass.getDeclaredMethod(setFieldName, field.getType());
                    V value = properties.get(field.getName());
                    if (value != null) {
                        if (field.getType().isArray()) {
                            if (value instanceof String) {
                                String valueStr = value.toString();
                                String[] valueArr = valueStr.substring(1, valueStr.length() - 1).split(", ");
                                setField.invoke(obj, (Object) valueArr);
                            } else {
                                setField.invoke(obj, value);
                            }
                        } else {
                            if (value.getClass().isArray()) {
                                if (field.getType() == byte.class) {
                                    byte val = Byte.parseByte(Array.get(value, 0).toString());
                                    setField.invoke(obj, val);
                                } else if (field.getType() == short.class) {
                                    short val = Short.parseShort(Array.get(value, 0).toString());
                                    setField.invoke(obj, val);
                                } else if (field.getType() == char.class) {
                                    char val = Array.get(value, 0).toString().charAt(0);
                                    setField.invoke(obj, val);
                                } else if (field.getType() == int.class) {
                                    int val = Integer.parseInt(Array.get(value, 0).toString());
                                    setField.invoke(obj, val);
                                } else if (field.getType() == long.class) {
                                    long val = Long.parseLong(Array.get(value, 0).toString());
                                    setField.invoke(obj, val);
                                } else if (field.getType() == float.class) {
                                    float val = Float.parseFloat(Array.get(value, 0).toString());
                                    setField.invoke(obj, val);
                                } else if (field.getType() == double.class) {
                                    double val = Double.parseDouble(Array.get(value, 0).toString());
                                    setField.invoke(obj, val);
                                } else if (field.getType() == java.sql.Date.class) {
                                    setField.invoke(obj, parseDate(Array.get(value, 0).toString()));
                                } else if (field.getType() == java.sql.Time.class) {
                                    setField.invoke(obj, parseTime(Array.get(value, 0).toString()));
                                } else if (field.getType() == java.util.Date.class) {
                                    setField.invoke(obj, parseDateTime(Array.get(value, 0).toString()));
                                } else {
                                    setField.invoke(obj, Array.get(value, 0));
                                }
                            } else {
                                setField.invoke(obj, value);
                            }
                        }
                    }
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static <T> T formToBean(Class<T> clazz, Map<String, String[]> parameterMap) {
        T t = null;

        try {
            Constructor<T> constructor = clazz.getConstructor();
            t = constructor.newInstance();
            populate(t, parameterMap);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        return t;
    }

    private static final SimpleDateFormat sdf = new SimpleDateFormat();

    private static java.sql.Date parseDate(String dateStr) {
        sdf.applyPattern("yyyy-MM-dd");
        java.sql.Date date = null;
        try {
            date = new java.sql.Date(sdf.parse(dateStr).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private static java.sql.Time parseTime(String timeStr) {
        sdf.applyPattern("HH:mm:ss");
        java.sql.Time time = null;
        try {
            time = new java.sql.Time(sdf.parse(timeStr).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    private static java.util.Date parseDateTime(String timeStr) {
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        java.util.Date time = null;
        try {
            time = sdf.parse(timeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }
}