package com.neta.sortalgorithm;


import com.neta.sortalgorithm.utils.ArrayUtils;

import static com.neta.sortalgorithm.utils.ArrayUtils.show;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 1, 3};
        sort(arr);
        show(arr);

        // 测试
        int[] testArr = ArrayUtils.test(80000);
        sort(testArr);
//        show(testArr);

    }

    public static void sort(int[] arr) {
        int min;
        int temp;
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            // 交换
            if (min != i) {
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
//            show(arr);
        }
        long end = System.currentTimeMillis();
        System.out.printf("Select Sort used %dms\n", end - start);
    }
}
