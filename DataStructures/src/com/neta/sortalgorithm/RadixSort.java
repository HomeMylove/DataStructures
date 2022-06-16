package com.neta.sortalgorithm;

import com.neta.sortalgorithm.utils.ArrayUtils;

import static com.neta.sortalgorithm.utils.ArrayUtils.show;

/**
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
//        sort(arr);
//        show(arr);
        int[] testArr = ArrayUtils.test(80000);
        long start = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.printf("Radix Sort used %dms\n", end - start);


    }

    public static void sort(int[] arr) {
        // 找出最大位数
        int max = arr[0];
        for (int i : arr) {
            if (i > max) max = i;
        }
        int maxLength = (max + "").length();

        // 第一轮
        // 定义一个二维数组,表示10个桶
        // 防止溢出，每一个的大小都为 arr.length
        int[][] bucket = new int[10][arr.length];

        // 用一个一位数组记录每一个桶里的有效数据个数
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j : arr) {
                int digitOfElement = j / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = j;
                bucketElementCounts[digitOfElement]++;
            }

            // 取出来
            int index = 0;
            // 遍历每一个
            for (int k = 0; k < bucket.length; k++) {
                // 有数据才取
                if (bucketElementCounts[k] != 0) {
                    // 循环
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }

                    bucketElementCounts[k] = 0;
                }

            }
        }
    }
}
