package top.fallenangel._21enum;

import java.util.Scanner;

public class EnumTest {
    public static void main(String[] args) {
        System.out.println("全部枚举：");
        for (ShapeEnum shape : ShapeEnum.values()) {
            System.out.println(shape + "：" + shape.getName() + "：" + shape.ordinal());
        }

        System.out.print("选一个：");
        System.out.println(ShapeEnum.valueOf(new Scanner(System.in).next()));
    }
}