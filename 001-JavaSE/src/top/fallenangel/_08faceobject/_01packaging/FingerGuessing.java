package top.fallenangel._08faceobject._01packaging;

import java.util.Random;
import java.util.Scanner;

public class FingerGuessing {
    public static void main(String[] args) {
        FingerGuessing fingerGuessing = new FingerGuessing();
        fingerGuessing.initial();
        fingerGuessing.start();
    }

    private Computer computer;
    private Human human;
    private int round;
    private final String[] options = {"剪刀", "石头", "布"};
    private final Scanner in = new Scanner(System.in);

    FingerGuessing() {
        System.out.println("                    ********************                    ");
        System.out.println("                    **   猜拳，开始   **                    ");
        System.out.println("                    ********************                    ");
        System.out.println();
    }

    public void initial() {
        Scanner in = new Scanner(System.in);

        System.out.println("出拳规则：1. 剪刀  2. 石头  3. 布");
        System.out.print("请选择对方角色(1. 刘备  2. 孙权  3. 曹操)：");
        computer = new Computer(in.nextInt());
        System.out.print("请输入你的姓名：");
        human = new Human(in.next());
    }

    public void start() {
        System.out.println("------------------------------------------------------------");
        System.out.println(computer.getName() + " VS " + human.getName());
        System.out.println();
        System.out.print("请出拳：1. 剪刀  2. 石头  3. 布(输入相应数字)：");
        int comFist = computer.showFist();
        int playerFist = human.showFist();
        while (playerFist < 1 || playerFist > 3) {
            System.out.print("输入不合法！请重新输入：");
            playerFist = human.showFist();
        }
        System.out.println("你出拳：" + options[playerFist - 1]);
        System.out.println(computer.getName() + "出拳：" + options[comFist - 1]);
        System.out.print("结果：");
        int compare = playerFist - comFist;
        if (compare == -2 || compare == 1) {
            // 赢了
            System.out.print("恭喜，你赢了！");
            human.winScore();
        } else if (compare == -1 || compare == 2) {
            // 输了
            System.out.print("你输了，真笨！^_^");
            computer.winScore();
        } else {
            // 平局
            System.out.print("和局，真衰！嘿嘿，等着瞧吧！");
        }
        round++;
        System.out.print("\n\n是否开始下一局？(y/n)：");
        char next = in.next().charAt(0);
        if ('y' == next) {
            start();
            return;
        }
        System.out.println("------------------------------------------------------------");
        System.out.println(computer.getName() + " VS " + human.getName());
        System.out.println("对战次数：" + round);
        System.out.println();
        System.out.println("姓名\t得分");
        System.out.println(human.getName() + '\t' + human.getScore());
        System.out.println(computer.getName() + '\t' + computer.getScore());
        System.out.println();
        String result;
        if (human.getScore() > computer.getScore()) {
            result = "恭喜恭喜，你赢啦！";
        } else if (human.getScore() < computer.getScore()) {
            result = "呵呵，笨笨，下次加油吧！";
        } else {
            result = "打成平手，下次再和你一较高下！";
        }
        System.out.print("结果：" + result);
    }
}

class Computer {
    private final String name;
    private int score;

    public Computer(int comRole) {
        String[] roles = {"刘备", "孙权", "曹操"};
        this.name = roles[comRole - 1];
    }

    public String getName() {
        return name;
    }

    public int showFist() {
        return new Random().nextInt(3) + 1;
    }

    public int getScore() {
        return score;
    }

    public void winScore() {
        score++;
    }
}

class Human {
    private final String name;
    private int score;
    private final Scanner in = new Scanner(System.in);

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int showFist() {
        return in.nextInt();
    }

    public int getScore() {
        return score;
    }

    public void winScore() {
        score++;
    }
}