package top.fallenangel._05array;

import java.util.Arrays;

public class NDimension {
    public static void main(String[] args) {
        int[][][] arr1 = {{{1, 2, 3, 5, 4, 8}, {2, 4, 5, 77}}, {{5, 7, 1, 5}, {5, 8, 7}, {1}}, {{5, 7, 4}, {5, 1, 2}, {5, 7, 4, 5, 2, 8, 5, 4, 5}, {5, 9, 6, 3, 2, 1, 7, 8, 5, 4, 52, 5}}};
        int[][][] arr2 = new int[5][1][4];
        arr1[2][0][2] = 965;
        arr2[3][0][2] = 965;
        System.out.println(Arrays.deepToString(arr1));
        System.out.println(Arrays.deepToString(arr2));
    }
}