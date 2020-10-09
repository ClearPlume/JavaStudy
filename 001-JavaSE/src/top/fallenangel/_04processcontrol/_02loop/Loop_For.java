package top.fallenangel._04processcontrol._02loop;

public class Loop_For {
    public static void main(String[] args) {
        // 输出等差数列，20个，差为3，起始值为1
        int count = 0, prevNum = 1;
        System.out.print("等差数列：" + 1 + "  ");
        for (int i = 1; count < 19; i++) {
            if (i - prevNum == 3) {
                System.out.print(i + "  ");
                prevNum = i;
                count++;
            }
        }
        System.out.println();
        System.out.println("****************************************************************************************************");

        // 输出等比数列，20个，比为3，起始值为1
        prevNum = 1;
        System.out.print("等比数列：" + prevNum + "  ");
        for (int i = 1; i < 20; i++) {
            System.out.print(prevNum * 3 + "  ");
            prevNum = prevNum * 3;
        }
        System.out.println();
        System.out.println("****************************************************************************************************");

        // 计算某个整数的阶乘：12
        int result = 1;
        for (int i = 1; i <= 12; i++) {
            result = result * i;
        }
        System.out.println("12的阶乘是：" + result);
        System.out.println("****************************************************************************************************");

        // 1到100累加的和
        result = 0;
        for (int i = 1; i <= 100; i++) {
            result = result + i;
        }
        System.out.println("1到100累加的和是：" + result);
        System.out.println("****************************************************************************************************");

        // 九九乘法表
        System.out.println("九九乘法表");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " * " + i + " = " + (i * j) + "\t");
            }
            System.out.println();
        }
        System.out.println("****************************************************************************************************");

        // 倒九九乘法表
        System.out.println("倒九九乘法表");
        for (int i = 9; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " * " + i + " = " + (i * j) + "\t");
            }
            System.out.println();
        }
        System.out.println("****************************************************************************************************");

        // 计算圆周率
        double PI = 0;
        count = 0;
        for (int i = 1; !(PI >= 3.1415926 && PI <= 3.1415927); i = i + 2, count++) {
            if (count % 2 == 0) {
                PI = PI + 4.0 / i;
            } else {
                PI = PI - 4.0 / i;
            }
        }
        System.out.print("PI = " + PI);
        System.out.print("\n祖冲之计算了" + count + "次");
    }
}