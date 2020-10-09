package top.fallenangel._04processcontrol._01select;

import java.util.Scanner;

public class Select_Switch {
    public static void main(String[] args) {
        System.out.print("请输入您想要的载具(0/1)：");
        int profession = new Scanner(System.in).nextInt();

        switch (profession) {
            case 0:
                System.out.println("飞机");
                break;
            case 1:
                System.out.println("坦克");
                break;
            default:
                System.out.println("找不到");
                break;
        }
    }
}