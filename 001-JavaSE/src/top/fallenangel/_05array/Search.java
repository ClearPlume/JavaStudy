package top.fallenangel._05array;

import java.util.Arrays;

public class Search {
    public static void main(String[] args) {
        binarySearch(10, 1, 2, 3, 5, 7, 8, 9, 10, 11);
        binarySearch(13, 1, 2, 3, 5, 7, 8, 9, 10, 11);
        binarySearch(-13, 1, 2, 3, 5, 7, 8, 9, 10, 11);
        binarySearch(3, 1, 2, 3, 5, 7, 8, 9, 10, 11);
        binarySearch(5, 1, 2, 3, 5, 7, 8, 9, 10, 11);
        binarySearch(4, 1, 2, 3, 5, 7, 8, 9, 10, 11);
        System.out.println("***********************************************");
        System.out.println(Arrays.binarySearch(new int[]{1, 2, 3, 5, 7, 8, 9, 10, 11}, 10));
        System.out.println(Arrays.binarySearch(new int[]{1, 2, 3, 5, 7, 8, 9, 10, 11}, 13));
        System.out.println(Arrays.binarySearch(new int[]{1, 2, 3, 5, 7, 8, 9, 10, 11}, -13));
        System.out.println(Arrays.binarySearch(new int[]{1, 2, 3, 5, 7, 8, 9, 10, 11}, 3));
        System.out.println(Arrays.binarySearch(new int[]{1, 2, 3, 5, 7, 8, 9, 10, 11}, 5));
        System.out.println(Arrays.binarySearch(new int[]{1, 2, 3, 5, 7, 8, 9, 10, 11}, 4));
    }

    /**
     * 二分查找
     *
     * @param ele 要查找的元素
     * @param arr 要查找的数组
     */
    @SafeVarargs
    static <T extends Comparable<T>> void binarySearch(T ele, T... arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid = -1;

        if (ele.compareTo(arr[start]) > 0 && ele.compareTo(arr[end]) < 0) {
            while (start <= end) {
                mid = (start + end) / 2;
                if (arr[mid].compareTo(ele) < 0) {
                    start = mid + 1;
                } else if (arr[mid].compareTo(ele) > 0) {
                    end = mid - 1;
                } else {
                    break;
                }
            }
        }

        if (mid == -1) {
            if (ele.compareTo(arr[start]) < 0) {
                System.out.println("数组中没有" + ele + "元素，但如果插入" + ele + "元素，它应该在" + start + "位置");
            } else {
                System.out.println("数组中没有" + ele + "元素，但如果插入" + ele + "元素，它应该在" + (end + 1) + "位置");
            }
        } else if (start > end) {
            System.out.println("数组中没有" + ele + "元素，但如果插入" + ele + "元素，它应该在" + start + "位置");
        } else {
            System.out.println(ele + "在数组中第" + mid + "角标");
        }
    }
}