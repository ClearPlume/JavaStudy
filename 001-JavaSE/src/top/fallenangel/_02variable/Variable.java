package top.fallenangel._02variable;

/**
 * 练习变量的定义和使用
 *
 * @author 杜海蛟
 * @version 1.0
 * @since 2020-07-14 15:25
 */
@SuppressWarnings("ALL")
public class Variable {
    // 定义在类中的变量为全局变量
    static int a = 20;
    // 同一作用域内，不允许变量重名
    // int a;

    /**
     * main方法，程序的入口
     * 定义在方法中的变量是局部变量
     *
     * @param args 方法中传入的变量为局部变量
     */
    public static void main(String[] args) {
        /* 变量的定义 */

        // 定义的同时赋值
        int a = 10;

        // 先定义再赋值
        int b;
        // 变量使用前必须有一次赋值
        // System.out.println("变量b的值是：" + b);
        b = 20;

        // 定义多个变量再分开赋值
        int i, j, k;
        i = 1;
        j = 2;
        k = 3;
        // 同一作用域内，不允许变量重名
        // int i;

        // 定义多个变量并同时赋值
        int e = 4, f = 5, g = 6;

        /* 变量的使用 */
        // 变量使用之前必须先赋值
        // "+"在此处为连接符，连接左右的值
        // 局部变量与全部变量同名时，以局部变量优先
        System.out.println("局部变量a的值是：" + a);
        // 若要使用全局变量，需添加“this”/"类名.变量名"
        System.out.println("全局变量a的值是：" + Variable.a);

        // 变量的值可变动，可再次赋值
        a = 20;
        System.out.println("变量a的值是：" + a);

        // 变量的值可互相传递，直接指定变量的值为另一个变量的值
        int z = b;
        System.out.println("变量z的值是：" + z);

        // 同时输出多个变量的值
        System.out.println("i的值是：" + i + "，j的值是：" + j + "，k的值是：" + k);

        // 块内部的变量是局部变量
        if (Thread.currentThread().isInterrupted()) {
            int t = 10;
        }

        // 异常块内部的变量是局部变量
        try {
            int t = 10;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}