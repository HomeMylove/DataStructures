package com.neta.sortalgorithm;

import com.neta.sortalgorithm.utils.ArrayUtils;

import static com.neta.sortalgorithm.utils.ArrayUtils.show;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, -789, 70,-2};
        int[] testArr = ArrayUtils.test(80000);
        long start = System.currentTimeMillis();
        sort(testArr,0,testArr.length-1);
//        sort(arr,0,arr.length-1);
//        sort2(arr,0,arr.length-1);
        long end = System.currentTimeMillis();
        System.out.printf("Quick Sort used %dms\n",end - start);
//        show(arr);

    }

    public static void sort(int[] arr, int l, int r) {
        if(l >= r ) return;
        int left = l,right = r;
        int pivot = arr[(left+right)/2];
        int temp = 0;
        while (left < right){
            while (left < right && arr[left] < pivot){
                left++;
            }
            while (left < right && arr[right] > pivot){
                right--;
            }
            if(left>=right){
                break;
            }
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            if(arr[left] == pivot){
                right--;
            }
            if(arr[right] == pivot){
                left++;
            }
        }

        sort(arr,l,left-1);
        sort(arr,left+1,r);


    }

    public static void sort2(int[] arr,int l,int r){
        if(l >= r) return;
        int left = l,right = r;
        int pivot = arr[left];
        while (left < right){
            while (left < right && arr[right] >= pivot){
                right--;
            }
            if(left<right){
                arr[left] = arr[right];
            }
            while (left < right && arr[left] <= pivot){
                left++;
            }
            if(left<right){
                arr[right] = arr[left];
            }

            if(left == right){
                arr[left] = pivot;
            }
        }
        // 左递归
        sort2(arr,l,left-1);
        // 右递归
        sort2(arr,left+1,r);

    }
}
