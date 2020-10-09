package top.fallenangel;

import java.util.Random;
import java.util.Scanner;

public class FirstWeekTest {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // 任意输入整数，判断是奇数还是偶数
        System.out.print("输入任意整数：");
        int num = in.nextInt();
        if (num % 2 == 0) {
            System.out.println("偶数");
        } else {
            System.out.println("奇数");
        }

        System.out.println("****************************************************************************************************");

        // 输入年龄，判断年龄所在的区间
        System.out.print("输入年龄：");
        int age = in.nextInt();
        if (age >= 0 && age <= 150) {
            if (age <= 5) {
                System.out.println("幼儿");
            } else if (age <= 10) {
                System.out.println("少年");
            } else if (age <= 18) {
                System.out.println("青少年");
            } else if (age <= 35) {
                System.out.println("青年");
            } else if (age <= 55) {
                System.out.println("中年");
            } else {
                System.out.println("老年");
            }
        } else {
            System.out.println("输入的年龄不合法");
        }

        System.out.println("****************************************************************************************************");

        // 根据天气和性别输出
        int weather = new Random().nextInt(2);
        boolean sex = new Random().nextBoolean();
        if (weather == 1) {
            System.out.print("晴天，" + (sex ? "男人" : "女人") + "：");
            System.out.println(sex ? "走起，出去玩耍！" : "擦点防晒霜，出去逛街！");
        } else {
            System.out.print("阴天，" + (sex ? "男人" : "女人") + "：");
            System.out.println(sex ? "出门带一把大黑伞！" : "出门带一把小花伞！");
        }

        System.out.println("****************************************************************************************************");

        // 输入月份，判断季节
        System.out.print("输入一个月份：");
        int month = in.nextInt();
        if (month >= 1 && month <= 12) {
            switch (month) {
                case 3:
                case 4:
                case 5:
                    System.out.println("春季");
                    break;
                case 6:
                case 7:
                case 8:
                    System.out.println("夏季");
                    break;
                case 9:
                case 10:
                case 11:
                    System.out.println("秋季");
                    break;
                default:
                    System.out.println("冬季");
                    break;
            }
        } else {
            System.out.println("输入的月份不合法！");
        }

        System.out.println("****************************************************************************************************");

        // 1000以内能被7整除的整数之和
        int sum = 0;
        for (num = 7; num <= 994; num = num + 7) {
            sum = sum + num;
        }
        System.out.println("1000以内能被7整除的数之和：" + sum);

        System.out.println("****************************************************************************************************");

        // 1 + 2 - 3 + .... + 100之和
        sum = 1;
        for (int i = 2; i <= 100; i++) {
            if (i % 2 == 0) {
                sum = sum + i;
            } else {
                sum = sum - i;
            }
        }
        System.out.println("1 + 2 - 3 + 4 .... + 100之和：" + sum);

        System.out.println("****************************************************************************************************");

        // 每天存2.5元，每到天数为５的倍数时就花6元，求存到100的天数
        int day = 0;
        double money = 0;
        while (money < 100) {
            day++;
            money = money + 2.5 - ((day % 5 == 0) ? 6 : 0);
        }
        System.out.println("经过" + day + "天可以存到100元");

        System.out.println("****************************************************************************************************");

        // 计算1! + 2! + 3! + ... + 10!之和
        sum = 0;
        for (int i = 1; i <= 10; i++) {
            int iFactorial = 1;
            for (int j = 1; j <= i; j++) {
                iFactorial = iFactorial * j;
            }
            sum = sum + iFactorial;
        }
        System.out.println("1~10的阶乘之和是：" + sum);

        System.out.println("****************************************************************************************************");

        System.out.print("是否再来一次？(Y/N)");
        char again = in.next().charAt(0);
        if (again == 'y' || again == 'Y') {
            System.out.println("****************************************************************************************************");
            main(args);
        } else {
            System.out.println("程序执行结束。");
        }
    }
}