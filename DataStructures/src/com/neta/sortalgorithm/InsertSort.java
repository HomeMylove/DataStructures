package com.neta.sortalgorithm;

import static com.neta.sortalgorithm.utils.ArrayUtils.show;
import static com.neta.sortalgorithm.utils.ArrayUtils.test;

public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {5,2,4,1,3};
//        sort(arr);
//        show(arr);
        int[] testArr = test(80000);
        sort(testArr);
//        show(testArr);
    }

    public static void sort(int[] arr){
        int insertVal;
        int insertIndex;
        long start = System.currentTimeMillis();
        for(int i = 1; i < arr.length; i++){

            // 定义待插入的数
            insertVal = arr[i];
            insertIndex = i - 1; // arr[1] 的前一个数

            // 给 insertVal找到位置
            while (insertIndex >= 0 && insertVal < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            // 找到了 这个值应该放在 insertIndex 的后面一位
            arr[insertIndex + 1] = insertVal;
        }
        long end = System.currentTimeMillis();

        System.out.printf("Insert Sort used %dms\n",end - start);
    }

    public static void sortFor(int[] arr){
        int val,index;
        for(int i = 1; i < arr.length; i++){
            val = arr[i];index = i - 1;
            for(; index >= 0 && val < arr[index];){
                arr[index+1] = arr[index];
                index--;
            }
            if(index != i - 1) arr[index+1] = val;
        }
    }

}
