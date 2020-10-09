package top.fallenangel._03operator;

@SuppressWarnings("ConstantConditions")
public class Operator {
    public static void main(String[] args) {
        // 算术运算符
        int i1 = 10;
        int i2 = 20;
        int i3 = i1 + i2;
        System.out.println(i3);

        int i4 = i2 - i1;
        System.out.println(i4);

        int i5 = i1 * i2;
        System.out.println(i5);

        int i6 = i2 / i1;
        System.out.println(i6);

        int i7 = i1 % 3;
        System.out.println(i7);

        int i8 = i1++;
        System.out.println("i8: " + i8 + ", i1: " + i1);

        int i9 = i2--;
        System.out.println("i9: " + i9 + ", i2: " + i2);

        // 关系运算符
        System.out.println(i1 > i2);
        System.out.println(i1 >= i2);
        System.out.println(i1 < i2);
        System.out.println(i1 <= i2);
        System.out.println((i1 == i2));
        System.out.println(i1 != i2);

        // 逻辑运算符
        System.out.println(i1 < i2 && i3 > i4);
        System.out.println(i1 < i2 & i3 > i4);
        System.out.println(i4 < i5 || i8 < i9);
        System.out.println(i4 < i5 | i8 < i9);
        System.out.println(!(i1 < i2));

        // 赋值运算符
        i9 = i8;
        System.out.println(i9);
        i8 *= i9;
        System.out.println(i8);

        // 条件运算符(三元运算符)
        String res = i8 > i9 ? "i8大于i9" : "i8小于i9";
        System.out.println(res);
    }
}