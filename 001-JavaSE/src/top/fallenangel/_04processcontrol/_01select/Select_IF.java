package top.fallenangel._04processcontrol._01select;

import java.util.Scanner;

/**
 * 练习流程控制语句 - if
 */
public class Select_IF {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        /* if语句 */

        // 出了这个门，你就别回来了
        System.out.print("请输入是否出门(Y/N)：");
        char out = in.next().charAt(0);

        if (out == 'Y') {
            System.out.println("真出去了？别回来了！");
        }

        // 身高超过1.2米，乘坐交通工具就会收费
        System.out.print("输入身高：");
        float height = in.nextFloat();

        if (height <= 1.2F) {
            System.out.println("乘坐交通工具是免费的");
        } else {
            System.out.println("乘坐交通工具要收费了");
        }

        // 1 + 1 = ?
        System.out.print("输入1 + 1的结果：");
        int sum = in.nextInt();

        if (sum == 2) {
            System.out.println("你算对啦！");
        } else {
            System.out.println("你算错了！");
        }

        // 帐户余额是否超过10000元？
        System.out.print("输入当前帐户余额：");
        int balance = in.nextInt();

        if (balance >= 10000) {
            System.out.println("当前帐户余额超过10000元，可以转帐。");
        } else {
            System.out.println("余额不足，无法转帐！");
        }

        // 600以上上清华，580-600上北大，550-580上复旦
        System.out.print("请输入分数：");
        short score = in.nextShort();

        if (score > 600) {
            System.out.println("恭喜，您可以上清华！");
        } else if (score >= 580) {
            System.out.println("恭喜，您可以上北大！");
        } else if (score >= 550) {
            System.out.println("恭喜，您可以上复旦！");
        } else {
            System.out.println("请等待下一批次。");
        }

        // 分数低于60不及格，60-70分及格，70-0分良好，90分以上优秀
        System.out.print("请输入分数：");
        byte singleScore = in.nextByte();

        if (singleScore >= 90) {
            System.out.println("优秀");
        } else if (singleScore >= 70) {
            System.out.println("良好");
        } else if (singleScore >= 60) {
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }

        // 0是法师，１是战士，２是坦克，３是刺克，４是射手，５是辅助
        System.out.print("输入职业：");
        byte profession = in.nextByte();

        if (profession == 0) {
            System.out.println("法师");
        } else if (profession == 1) {
            System.out.println("战士");
        } else if (profession == 2) {
            System.out.println("坦克");
        } else if (profession == 3) {
            System.out.println("刺克");
        } else if (profession == 4) {
            System.out.println("射手");
        } else if (profession == 5) {
            System.out.println("辅助");
        }

        // 判断控制台输入数字的奇偶性
        System.out.print("请输入数字：");
        int num = in.nextInt();

        if (num % 2 == 0) {
            System.out.println("此数为偶数");
        } else {
            System.out.println("此数为奇数");
        }

        // 声控灯触发需要三个条件：有电、有声、光线暗
        System.out.print("是否有电(Y/N)：");
        boolean hasElect = in.next().charAt(0) == 'Y';
        System.out.print("当前分贝：");
        byte decibel = in.nextByte();
        System.out.print("当前光强(Lux)：");
        short lux = in.nextShort();

        if (!hasElect) {
            System.out.println("没电");
        } else if (!(decibel >= 20)) {
            System.out.println("声音太小");
        } else if (!(lux <= 50)) {
            System.out.println("光线太强");
        } else {
            System.out.println("灯亮了");
        }

        // 西安落户条件(任一满足即可)：在西安上学；在西安买房；符合条件的专业人才；在西安投资创业
        System.out.print("是否在西安上学(Y/N)：");
        boolean school = in.next().charAt(0) == 'Y';
        System.out.print("是否有在西安买房(Y/N)：");
        boolean house = in.next().charAt(0) == 'Y';
        System.out.print("是否有专业特殊技能(Y/N)：");
        boolean talent = in.next().charAt(0) == 'Y';
        System.out.print("是否有在西安投资创业(Y/N)：");
        boolean buss = in.next().charAt(0) == 'Y';

        if (school || house || talent || buss) {
            System.out.println("您满足在西安落户的要求");
        } else {
            System.out.println("您不满足在西安落户的要求");
        }
    }
}