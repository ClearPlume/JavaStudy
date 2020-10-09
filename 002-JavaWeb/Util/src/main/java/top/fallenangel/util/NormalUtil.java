package top.fallenangel.util;

import java.util.Collection;

@SuppressWarnings("unused")
public class NormalUtil {

    /**
     * 显示一个界面
     *
     * @param uiName  界面名称。输入“**NO-SHOW-HEADER**”则不显示前缀标题及空行。
     * @param options 界面选项
     */
    public static void showUI(String systemName, String uiName, String... options) {
        if (!"**NO-SHOW-HEADER**".equals(uiName)) {
            System.out.println("******************************欢迎光临" + systemName + " - " + uiName + "******************************");
            System.out.println();
            System.out.println();
        }
        StringBuilder ops = new StringBuilder();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
            ops.append(i + 1);
            if (i + 1 < options.length) {
                ops.append('/');
            }
        }
        if (options.length > 0) {
            System.out.print("请选择(" + ops + ")：");
        }
    }

    /**
     * 睡眠
     *
     * @param millis 睡眠时长，毫秒
     */
    public static void sleep(long millis) {
        sleep(millis, 0);
    }

    /**
     * 睡眠
     *
     * @param millis 睡眠时长，毫秒
     * @param nanos  睡眠时长，纳秒
     */
    public static void sleep(long millis, int nanos) {
        try {
            Thread.sleep(millis, nanos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 显示单个对象的数据
     *
     * @param t 对象
     */
    public static <T> void showData(T t) {
        System.out.println(t);
    }

    /**
     * 显示对象集合的数据
     *
     * @param collection 对象集合
     */
    public static <T> void showDataList(Collection<T> collection) {
        for (T t : collection) {
            showData(t);
        }
    }

    public static void enterContinue() {
        System.out.print("如上。回车继续...");
        InputUtil.inEnter();
    }
}