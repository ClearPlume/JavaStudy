package top.fallenangel.springboot.p2p.util;

import java.util.Random;

public class RandomUtil {
    /**
     * 生成指定位数的随机数
     *
     * @param digit 位数
     * @return 生成结果
     */
    public static String num(int digit) {
        StringBuilder num = new StringBuilder();

        for (int i = 0; i < digit; i++) {
            num.append(new Random().nextInt(10));
        }
        return num.toString();
    }
}
