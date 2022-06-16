package com.neta.sortalgorithm;

import com.neta.sortalgorithm.utils.ArrayUtils;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        ArrayUtils.show(arr);
//        int[] testArr = ArrayUtils.test(80000);
//        long start = System.currentTimeMillis();
//        mergeSort(testArr, 0, testArr.length - 1, new int[testArr.length]);
//        long end = System.currentTimeMillis();
//        System.out.printf("Merge Sort used %dms\n", end - start);


    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 左
            mergeSort(arr, left, mid, temp);
            // 右
            mergeSort(arr, mid + 1, right, temp);
            // 合并
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * @param arr   待排序数组
     * @param left  左边索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  临时数组
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;  // 初始化 i
        int j = mid + 1;  // 初始化 j
        int t = 0;  // temp 的索引

        // 填充到 temp 数组
        // 直到一边处理完毕
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        // 把另一边也填充
        while (i <= mid) {
            // 左边剩余
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }

        // temp 拷贝到 arr
        // 不是每次都拷贝所有
        // 拷贝 到 left --- right 的范围内
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft++] = temp[t++];
        }
    }
}
