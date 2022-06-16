package com.neta.sortalgorithm.utils;

public class ArrayUtils {

    public static void show(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i == arr.length - 1) {
                System.out.print("]\n");
            } else {
                System.out.print(", ");
            }
        }
    }

    public static int[] test(int n){
        int[] ints = new int[n];
        for (int i = 0; i < n; i++){
            ints[i] = (int)(Math.random() * n);
        }
        return ints;
    }

}
