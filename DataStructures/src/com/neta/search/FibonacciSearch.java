package com.neta.search;

import java.util.Arrays;

/**
 * 斐波那契查找
 */
public class FibonacciSearch {
    public static int maxSize = 20;
    public static void main(String[] args) {

    }
    // 先获取斐波那契数列
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for(int i = 2; i < f.length; i++){
            f[i] = f[i-1]+f[i-2];
        }
        return f;
    }

    //查找方法
    public static int fibSearch(int[] arr,int key){
        int low = 0;
        int high = arr.length - 1;
        int k = 0;   // 分割数值的下标 low + F(k-1)
        int mid = 0;
        int[] f = fib();
        while (high > f[k] - 1){
            k++;
        }
        // 扩容
        int[] temp = Arrays.copyOf(arr,f[k]);
        // 用最后一个值填充
        for(int i = high + 1; i <temp.length; i++){
            temp[i] = arr[high];
        }

        while (low <= high){
            mid = low + f[k-1] -1;
            if(key < temp[mid]){
                // 向左边
                high  = mid -1;
                k--;
            }else if(key > temp[mid]){
                low = mid + 1;
                k -= 2;
            }else {
                if(mid <= high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return  -1;
    }
}
