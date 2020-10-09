package top.fallenangel._05array;

import java.util.Arrays;

public class Compare {
    public static void main(String[] args) {
        bubbling(1, 2, 5, 4, 7, 9, 6, 3, 8);
        bubbling('1', '2', '5', '4', '7', '9', '6', '3', '8');
        bubbling("1", "2", "5", "4", "7", "9", "6", "3", "8");
        System.out.println("******************************");
        insertSort(1, 2, 5, 4, 7, 9, 6, 3, 8);
        insertSort('1', '2', '5', '4', '7', '9', '6', '3', '8');
        insertSort("1", "2", "5", "4", "7", "9", "6", "3", "8");

        Integer[] arr = {1, 2, 5, 4, 7, 9, 6, 3, 8};
        //noinspection ComparatorCombinators
        Arrays.sort(arr, (o1, o2) -> {// noinspection Convert2MethodRef
            return o1.compareTo(o2);});
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序，常规递增计数法
     *
     * @param arr 任意需要排序的数列
     */
    @SafeVarargs
    static <T extends Comparable<T>> void bubbling(T... arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) < 0) {
                    T tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插值排序
     *
     * @param arr 需要排序的数组
     */
    @SafeVarargs
    static <T extends Comparable<T>> void insertSort(T... arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min]) > 0) {
                    min = j;
                }
            }
            if (arr[min].compareTo(arr[i]) != 0) {
                T tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}