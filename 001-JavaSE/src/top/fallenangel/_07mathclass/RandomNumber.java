package top.fallenangel._07mathclass;

public class RandomNumber {
    public static void main(String[] args) {
        RandomNumber rm = new RandomNumber();

        for (int i = 0; i < 100; i++) {
            System.out.println("0与1之间的随机数：" + rm.random01());
        }
        for (int i = 0; i < 100; i++) {
            System.out.println("0与50之间的随机数：" + rm.random0_50());
        }
        for (int i = 0; i < 100; i++) {
            System.out.println("10与20间的随机数：" + rm.random10_20());
        }
    }

    int random01() {
        return Math.random() < 0.5 ? 0 : 1;
    }

    int random0_50() {
        return (int) (Math.random() * 50);
    }

    int random10_20() {
        return (int) (Math.random() * 10 + 10);
    }
}