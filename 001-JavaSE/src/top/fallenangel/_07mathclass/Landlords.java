package top.fallenangel._07mathclass;

import java.util.Arrays;
import java.util.Random;

/**
 * 模拟斗地主发牌
 */
@SuppressWarnings("ALL")
public class Landlords {
    // 完整的一套牌
    static String[] pokers = new String[54];
    // 标记某张牌是否取出过
    boolean[] dealed = new boolean[54];
    // 张、赵、刘、底牌
    String[] zhang = new String[17];
    String[] zhao = new String[17];
    String[] liu = new String[17];
    String[] dp = new String[3];
    // 三个人的牌组和底牌
    String[][] pz = {zhang, zhao, liu, dp};
    // 四种花色
    String[] huaSe = {"♣", "♦", "♥", "♠"};

    public static void main(String[] args) {
        Landlords l = new Landlords();

        // 按顺序填充，随机发牌
        System.out.println("按顺序填充，随机发牌：");
        l.initialPokersOrder();
        System.out.println(Arrays.toString(pokers));
        l.dealPokerRandom();
        l.showPokers();

        l.clearPokers();

        // 随机填充，按顺序发牌
        System.out.println("随机填充，按顺序发牌");
        l.initialPokersRandom();
        System.out.println(Arrays.toString(pokers));
        l.dealPokerOrder();
        l.showPokers();
    }

    /**
     * 初始化扑克牌，随机填充54张牌
     */
    void initialPokersRandom() {
        for (String hua : huaSe) {
            for (int i = 1; i <= 13; i++) {
                pokers[randomPok()] = combinePok(i) + hua;
            }
        }
        for (int i = 0; i < 54; i++) {
            if (!dealed[i]) {
                pokers[i] = "❉";
                dealed[i] = true;
                break;
            }
        }
        for (int i = 0; i < 54; i++) {
            if (!dealed[i]) {
                pokers[i] = "✲";
                dealed[i] = true;
                break;
            }
        }
    }

    String combinePok(int i) {
        String Pok;
        switch (i) {
            case 1:
                Pok = "A";
                break;
            case 11:
                Pok = "J";
                break;
            case 12:
                Pok = "Q";
                break;
            case 13:
                Pok = "K";
                break;
            default:
                Pok = Integer.toString(i);
                break;
        }
        return Pok;
    }

    /**
     * 初始化扑克牌，按顺序完整填充54张牌
     */
    void initialPokersOrder() {
        int index = 0;
        for (String hua : huaSe) {
            for (int i = 1; i <= 13; i++) {
                pokers[index++] = combinePok(i) + hua;
            }
        }
        pokers[52] = "❉";
        pokers[53] = "✲";
    }

    /**
     * 随机发牌
     */
    void dealPokerRandom() {
        for (String[] p : pz) {
            for (int i = 0; i < p.length; i++) {
                int pai = randomPok();
                p[i] = pokers[pai];
            }
        }
    }

    /**
     * 顺序发牌
     */
    void dealPokerOrder() {
        int index = 0;
        for (String[] p : pz) {
            if (p.length == 3) {
                break;
            }
            for (int i = 0; i < p.length; i++) {
                p[i] = pokers[index++];
            }
        }
        dp[0] = pokers[51];
        dp[1] = pokers[52];
        dp[2] = pokers[53];
    }

    /**
     * 从0-53这54个数字中随机取出一个数字，并保证每个数字只取出一次
     *
     * @return 取到的数字
     */
    int randomPok() {
        int pok = new Random().nextInt(54);
        while (dealed[pok]) {
            pok = new Random().nextInt(54);
        }
        dealed[pok] = true;
        return pok;
    }

    /**
     * 展示三个人的牌和底牌
     */
    void showPokers() {
        System.out.println("张飞：" + arrayToString(zhang));
        System.out.println("赵云：" + arrayToString(zhao));
        System.out.println("刘备：" + arrayToString(liu));
        System.out.println("底牌：" + arrayToString(dp));
    }

    <T> String arrayToString(T[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append('[').append('\t');
        for (T t : array) {
            sb.append(t).append('\t');
        }
        sb.append(']');
        return sb.toString();
    }

    void clearPokers() {
        //noinspection ExplicitArrayFilling
        for (int i = 0; i < pokers.length; i++) {
            pokers[i] = null;
        }

        Arrays.fill(dealed, false);
        Arrays.fill(zhang, null);
        Arrays.fill(zhao, null);
        Arrays.fill(liu, null);
        Arrays.fill(dp, null);
    }
}