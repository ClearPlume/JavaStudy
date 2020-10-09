package top.fallenangel._06method;

import java.io.File;
import java.util.Objects;

public class RecursionTest {
    @SuppressWarnings("StringEquality")
    public static void main(String[] args) {
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        String str5 = "a" + "b";
        System.out.println(str3 == str4);
        System.out.println(str3 == str5);
        System.out.println(str4 == str5);

        RecursionTest rt = new RecursionTest();
        int num = 10;

        System.out.println(num + "的阶乘是：" + rt.jieCheng(num));
        num = 8;
        System.out.println(num + "个月后的兔子数量是：" + rt.rabbitNum(num));
        num = 12345;
        System.out.print(num + "反转之后是：");
        rt.reverse(12345);
        System.out.println();
        String path = "D:\\360zip";
        System.out.println(path + "中的目录结构：");
        rt.loadDirectory(path);

        int a = 6, b = 3;
        System.out.print("不用加号的加法：");
        System.out.println(a + " + " + b + " = " + rt.add(a, b));
        System.out.print("不用减号的减法：");
        System.out.println(a + " - " + b + " = " + rt.minus(a, b));
    }

    /**
     * 计算n的阶乘
     *
     * @param n 计算这个数字的阶乘
     *
     * @return 计算结果
     */
    int jieCheng(int n) {
        if (n > 1) {
            return n * jieCheng(n - 1);
        } else {
            return 1;
        }
    }

    /**
     * 计算几个月后兔子的数量
     *
     * @param month 月数
     *
     * @return 计算结果
     */
    int rabbitNum(int month) {
        if (month == 0) {
            return 2;
        } else {
            if (month % 2 == 0) {
                return 2 * rabbitNum(month - 1);
            } else {
                return rabbitNum(month - 1);
            }
        }
    }


    /**
     * 反转一个数字
     *
     * @param num 要反转的数字
     */
    void reverse(int num) {
        System.out.print(num % 10);
        if (num / 10 != 0) {
            reverse(num / 10);
        }
    }

    /**
     * 递归打印目录中所有文件
     *
     * @param path 目录
     */
    void loadDirectory(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                for (File f : Objects.requireNonNull(file.listFiles())) {
                    loadDirectory(f.getAbsolutePath());
                }
            } else {
                System.out.println(file.getAbsolutePath());
            }
        }
    }

    /**
     * a ^ b为不进位加法
     * a & b为需要进位的地方，左移一位即为进位结果
     * 不进位加法和结果与进位的结果相加则为加法和
     * 重复相加(不进位加法与进位)，直到结果不再变化
     * a  0000 0011
     * b  0000 0001
     * a  0000 0010    a ^ b           0000 0000    0000 0100    0000 0100
     * b  0000 0010    (a & b) << 1    0000 0100    0000 0000    0000 0000
     *
     * @param a 加数a
     * @param b 加数b
     *
     * @return 和
     */
    int add(int a, int b) {
        int _a;
        while (b != 0) {
            _a = a ^ b;
            b = (a & b) << 1;
            a = _a;
        }
        return a;
    }

    /**
     * a - b等价于a + b的补码
     *
     * @param a 被减数
     * @param b 减数
     *
     * @return 差
     */
    int minus(int a, int b) {
        b = add(~b, 1);
        return add(a, b);
    }
}