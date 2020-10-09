package top.fallenangel.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

@SuppressWarnings("unused")
public class InputUtil {
    private static final Scanner in = new Scanner(System.in);

    public static int inInt() {
        return in.nextInt();
    }

    public static byte inByte() {
        return in.nextByte();
    }

    public static String inStr() {
        return in.next();
    }

    public static void inEnter() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static char inChar() {
        return in.next().charAt(0);
    }

    public static double inDouble() {
        return in.nextDouble();
    }
}