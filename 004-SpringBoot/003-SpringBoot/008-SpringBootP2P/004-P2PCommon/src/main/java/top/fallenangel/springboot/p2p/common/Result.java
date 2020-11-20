package top.fallenangel.springboot.p2p.common;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private static final Map<String, Object> result;

    static {
        result = new HashMap<>();
    }

    public static Map<String, Object> success() {
        setValue("code", 0, "success", true, "msg", "ok");
        return result;
    }

    public static Map<String, Object> success(String msg) {
        setValue("code", 0, "success", true, "msg", msg);
        return result;
    }

    public static Map<String, Object> success(int code, String msg) {
        setValue("code", code, "success", true, "msg", msg);
        return result;
    }

    public static Map<String, Object> error() {
        setValue("code", 0, "success", false, "msg", "error");
        return result;
    }

    public static Map<String, Object> error(String msg) {
        setValue("code", 0, "success", false, "msg", msg);
        return result;
    }

    public static Map<String, Object> error(int code, String msg) {
        setValue("code", code, "success", false, "msg", msg);
        return result;
    }

    private static void setValue(Object... keyValues) {
        for (int i = 0; i < keyValues.length; i += 2) {
            result.put(keyValues[i].toString(), keyValues[i + 1]);
        }
    }
}
