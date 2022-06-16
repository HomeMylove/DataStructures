package com.neta.search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        // 注意：该数组必须是有序的;
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1024};
        System.out.println((binarySearch(arr, 1000, 0, arr.length - 1)));
    }

    public static ArrayList<Integer> binarySearch(int[] arr, int val, int left, int right) {
        if (left > right) {
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        if (arr[mid] > val) {
            return binarySearch(arr, val, left, mid - 1);
        } else if (arr[mid] < val) {
            return binarySearch(arr, val, mid + 1, right);
        } else {
            ArrayList<Integer> result = new ArrayList<>();
            int temp = mid - 1;
            while (temp > 0 && arr[temp] == val) {
                result.add(temp--);
            }
            result.add(mid);
            temp = mid + 1;
            while (temp < arr.length - 1 || arr[temp] == val) {
                result.add(temp++);
            }
            return result;
        }
    }
}
