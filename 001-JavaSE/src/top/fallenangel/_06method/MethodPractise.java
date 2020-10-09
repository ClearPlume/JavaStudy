package top.fallenangel._06method;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings({"ALL", "SpellCheckingInspection"})
public class MethodPractise {
    static Scanner in = new Scanner(System.in);
    static double PI = 3.14;

    // 长方形的周长和面积
    int juXingZhouChang(int width, int height) {
        return 2 * (width + height);
    }

    int juXingMianJi(int width, int height) {
        return width * height;
    }

    // 圆的周形和面积
    double yuanZhouChang(int r) {
        return 2 * PI * r;
    }

    double yuanMianJi(int r) {
        return PI * r * r;
    }

    // 正方形的周长和面积
    int zhengFXZhouChang(int width) {
        return width * 4;
    }

    int zhengFXMianJi(int width) {
        return width * width;
    }

    // 猜拳
    void caiQuan(String playerOption) {
        int win;
        List<String> options = Arrays.asList("布", "剪刀", "石头");

        if (!options.contains(playerOption)) {
            System.out.println("输入不合法！必须输入(布，剪刀，石头)之一！");
            System.out.print("猜拳，请猜(布，剪刀，石头)：");
            caiQuan(in.next());
            return;
        }

        int computer = new Random().nextInt(3);
        int player = options.indexOf(playerOption);

        if (player == 0 && computer == 2) {
            win = computer - player;
        } else {
            win = player - computer;
        }

        if (win > 0) {
            System.out.println("恭喜，你赢了！");
        } else if (win < 0) {
            System.out.println("你输啦！！！！");
            System.out.print("猜拳，请猜(布，剪刀，石头)：");
            caiQuan(in.next());
        } else {
            System.out.println("平局！！！！！");
            System.out.print("猜拳，请猜(布，剪刀，石头)：");
            caiQuan(in.next());
        }
    }

    // 猜数
    void guessNumber(int playerGuess, int number) {
        if (playerGuess == number) {
            System.out.println("恭喜你，猜对了！");
        } else {
            if (playerGuess > number) {
                System.out.println("猜大了");
            } else {
                System.out.println("猜小了");
            }
            System.out.print("请重新猜数：");
            guessNumber(in.nextInt(), number);
        }
    }

    // 计算三角形的斜边长
    double sanJX(int a, int b) {
        return Math.sqrt(a * a + b * b);
    }

    public static void main(String[] args) {
        MethodPractise mp = new MethodPractise();

        // 长方形
        System.out.print("输入长方形的长和宽，用逗号隔开：");
        String[] input = in.next().split(",");
        int width = Integer.parseInt(input[0]);
        int height = Integer.parseInt(input[1]);
        System.out.println("长方形的周长：" + mp.juXingZhouChang(width, height));
        System.out.println("长方形的面积：" + mp.juXingMianJi(width, height));

        // 圆
        System.out.print("输入圆的半径：");
        int r = in.nextInt();
        System.out.println("圆的周长：" + mp.yuanZhouChang(r));
        System.out.println("圆的面积：" + mp.yuanMianJi(r));

        // 正方形
        System.out.print("输入正方形的边长：");
        width = in.nextInt();
        System.out.println("正方形的周长：" + mp.zhengFXZhouChang(width));
        System.out.println("正方形的面积：" + mp.zhengFXMianJi(width));

        // 猜拳
        System.out.print("猜拳，请猜(布，剪刀，石头)：");
        mp.caiQuan(in.next());

        // 猜数字
        System.out.print("猜数字，随意猜一个数字：");
        int number = new Random().nextInt(30);
        mp.guessNumber(in.nextInt(), number);

        // 三角形
        System.out.print("输入三角形的长和宽，用逗号隔开：");
        input = in.next().split(",");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        System.out.println("三角形的斜边长：" + mp.sanJX(a, b));
    }
}