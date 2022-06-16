package com.neta.search;

import java.util.Arrays;

/**
 * 线性查找
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = new int[10];

        for(int i = 0; i <arr.length;i++){
            arr[i] = (int)(Math.random()*10);
        }

        int search = search(arr, 8);
        System.out.println(search);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 查找并返回下标
     * @param arr 数组
     * @param value 值
     * @return 下标
     */
    public static int search(int[] arr,int value){
        for(int i = 0; i <arr.length; i++){
            if(arr[i] == value) return i;
        }
        return -1;
    }
}
