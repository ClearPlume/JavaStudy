package top.fallenangel;

import java.util.Random;
import java.util.Scanner;

/**
 * 基础测试题
 */
public class Phase0Test {
    public static void main(String[] args) {
        level();
        System.out.println("************************************************************");
        car();
        System.out.println("************************************************************");
        guessEntry();
    }

    /**
     * 基础测试第一题
     * 一个玩家的星级在10星及以下是青铜,11-20星是白银，21-30星是黄金，31-40星是钻石，41星及以上是王者。
     * 随机给定任意大于等于0的数字星级，求此玩家的星级。
     */
    static void level() {
        int star = new Random().nextInt(100);

        if (star <= 10) {
            System.out.println("青铜");
        } else if (star <= 20) {
            System.out.println("白银");
        } else if (star <= 30) {
            System.out.println("黄金");
        } else if (star <= 40) {
            System.out.println("钻石");
        } else {
            System.out.println("王者");
        }
    }

    /**
     * 基础测试第二题
     * 小明的工资是15000元/月，想买辆凯迪拉克需花费25万元，每季度都要还房贷20000元，求小明几个月能够买辆凯迪拉克？
     */
    static void car() {
        int salary = 15000;
        // 房贷
        int fangDai = 20000;
        // 房贷周期
        int fangDaiRate = 3;
        // 余额
        int yuE = 0;
        // 凯迪拉克
        @SuppressWarnings("SpellCheckingInspection") int KDLK = 250000;
        int month = 0;

        while (yuE <= KDLK) {
            month++;
            yuE = yuE + salary;
            if (month % fangDaiRate == 0) {
                yuE = yuE - fangDai;
            }
        }

        System.out.println("小明" + month + "个月可以买辆凯迪拉克");
    }

    /**
     * 基础测试第三题
     * 系统随机产生一个整数，用户通过键盘输入的方式来完成数字的猜测：
     * 假设,系统给定数字15：
     * 用户猜测17，请输出：猜大了
     * 用户猜测14，请输出：猜小了
     * 用户猜测15，请输出：恭喜你，猜对了！
     */
    static void guessEntry() {
        final int num = new Random().nextInt(200);
        final Scanner in = new Scanner(System.in);
        int time = 0;
        guess(num, in, time + 1);
    }

    static void guess(int num, Scanner in, int time) {
        System.out.print("猜数字：");
        int guess = in.nextInt();

        if (guess > num) {
            System.out.println("猜大了");
            guess(num, in, time + 1);
        } else if (guess < num) {
            System.out.println("猜小了");
            guess(num, in, time + 1);
        } else {
            System.out.println("恭喜你，猜对了！用了" + time + "次！");
        }
    }
}