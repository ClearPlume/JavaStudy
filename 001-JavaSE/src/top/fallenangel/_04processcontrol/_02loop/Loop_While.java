package top.fallenangel._04processcontrol._02loop;

public class Loop_While {
    public static void main(String[] args) {
        // 九九乘法表
        int i = 1;
        while (i <= 9) {
            int j = 1;
            while (j <= i) {
                System.out.print(j + " * " + i + " = " + i * j + "\t");
                j++;
            }
            i++;
            System.out.println();
        }

        System.out.println("***************************************************************");

        // 计算圆周率
        double PI = 0;
        int count = 0;
        int operator = 1;
        boolean plus = true;
        while (!(PI >= 3.1415926 && PI <= 3.1415927)) {
            if (plus) {
                PI = PI + 4.0 / operator;
            } else {
                PI = PI - 4.0 / operator;
            }
            count++;
            operator = operator + 2;
            plus = !plus;
        }

        System.out.println("PI = " + PI);
        System.out.print("祖冲之算了" + count + "次");
    }
}