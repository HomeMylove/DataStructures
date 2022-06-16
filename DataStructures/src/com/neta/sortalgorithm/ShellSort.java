package com.neta.sortalgorithm;

import com.neta.sortalgorithm.utils.ArrayUtils;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 6, 8, 9, 5, 1, 0, 4};
//        sort(arr);
        int[] testArr = ArrayUtils.test(80000);
        sort(testArr);
    }

    public static void sort(int[] arr) {
        int n = arr.length;
        if (n == 2) return;
        long startTime = System.currentTimeMillis();
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int start = 0; start < gap; start++) {
                // 插入排序
                for (int i = start + gap; i < n; i += gap) {
                    int val = arr[i], j = i - gap;
                    for (; j >= 0; j -= gap) {
                        if (arr[j] > val) {
                            arr[j + gap] = arr[j];
                        } else break;
                    }
                    if (j != i - gap) arr[j + gap] = val;
                }
            }
//            System.out.println(Arrays.toString(arr));
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("Shell Sort used %dms\n",endTime-startTime);
    }
}
