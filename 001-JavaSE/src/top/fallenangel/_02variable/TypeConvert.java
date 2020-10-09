package top.fallenangel._02variable;

/**
 * 练习类型的转换
 */
@SuppressWarnings("ALL")
public class TypeConvert {
    public static void main(String[] args) {
        /* 自动类型转换 */

        // 整数型字面量的值没有超过byte short char的取值范围时，可直接将其赋值给byte short char
        byte b1 = 127;
        short s1 = 32767;
        char c1 = 65; // char c = 'A';

        // 小类型赋值给大类型时
        byte b2 = 127;
        short s2 = b2;
        int i1 = s2;

        // byte short char 做运算时，先转为int
        byte b3 = (byte) (b2 - (byte) 10);

        // 小类型与大类型做运算，结果一定是大类型
        int i2 = b1 + 15;

        /*  */
    }
}