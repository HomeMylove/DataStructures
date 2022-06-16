package com.neta.sortalgorithm;

import com.neta.sortalgorithm.utils.ArrayUtils;

import static com.neta.sortalgorithm.utils.ArrayUtils.show;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 1, 3};

//        sort(arr);
//        show(arr);
        int[] testArr = ArrayUtils.test(80000);
        sort(testArr);
    }

    public static void sort(int[] arr) {
        int temp;
        boolean flag = false;  // 标识，是否进行过交换
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true; // 代表交换过啦
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if(!flag) // 一次都没有交换
                break;
        }
        long end = System.currentTimeMillis();
        System.out.printf("Bubble Sorting used %dms\n",end - start);
    }
}
