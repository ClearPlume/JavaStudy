package top.fallenangel._05array;

public class ArrayTest {

    @SuppressWarnings("ManualArrayCopy")
    public static void main(String[] args) {
        // 将1-100存入数组并取出打印
        int[] arr1 = new int[100];

        for (int i = 0; i < 100; i++) {
            arr1[i] = i + 1;
        }

        for (int i : arr1) {
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.println("****************************************************************************************************");

        // 将a-z存入数组
        char[] arr2 = new char[26];

        for (char c = 'a'; c <= 'z'; c++) {
            arr2[c - 97] = c;
        }

        for (char c : arr2) {
            System.out.print(c + "\t");
        }
        System.out.println();
        System.out.println("****************************************************************************************************");

        // 将学生存入数组
        String[] arr3 = new String[]{"张三", "李四", "王五", "赵六", "钱七"};

        for (String name : arr3) {
            System.out.print(name + "\t");
        }
        System.out.println();
        System.out.println("****************************************************************************************************");

        // 将扑克牌存入数组
        String[] poker = new String[54];
        // 四种花色
        String[] huaSe = new String[]{"♣", "♦", "♥", "♠"};
        // 每张牌的索引
        int index = 0;

        // 遍历四种花色
        for (String hua : huaSe) {
            // 遍历1-13
            for (int i = 1; i <= 13; i++) {
                // 每张牌
                // 2-10直接使用
                String pai;
                switch (i) {
                    case 1:
                        pai = "A";
                        break;
                    case 11:
                        pai = "J";
                        break;
                    case 12:
                        pai = "Q";
                        break;
                    case 13:
                        pai = "K";
                        break;
                    default:
                        pai = String.valueOf(i);
                        break;
                }
                // 将1、11、12、13替换为A、J、Q、K
                poker[index++] = hua + pai;
            }
        }
        poker[52] = "❉";
        poker[53] = "✲";

        for (String paiP : poker) {
            System.out.print(paiP + "\t");
            if (paiP.endsWith("K")) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("****************************************************************************************************");

        // 在数组第3位插入元素96
        int[] arr4 = {1, 2, 3, 4, 0};

        for (int ele : arr4) {
            System.out.print(ele + "\t");
        }
        System.out.println();

        for (int i = arr4.length - 1; i >= 2; i--) {
            arr4[i] = arr4[i - 1];
        }
        arr4[2] = 96;

        for (int ele : arr4) {
            System.out.print(ele + "\t");
        }
        System.out.println();

        // 删除数组第三位
        for (int i = 2; i < arr4.length - 1; i++) {
            arr4[i] = arr4[i + 1];
        }

        arr4[arr4.length - 1] = 0;

        for (int ele : arr4) {
            System.out.print(ele + "\t");
        }
        System.out.println();
        System.out.println("****************************************************************************************************");

        // 数组扩容
        /*int[] arr5 = new int[10];
        for (int i = 0; i < arr4.length; i++) {
            arr5[i] = arr4[i];
        }
        arr4 = arr5;*/
        //arr4 = Arrays.copyOf(arr4, 10);
        int[] arrTmp = new int[10];
        System.arraycopy(arr4, 0, arrTmp, 0, arr4.length);
        arr4 = arrTmp;
        for (int ele : arr4) {
            System.out.print(ele + "\t");
        }
        System.out.println();
        System.out.println("****************************************************************************************************");
    }
}