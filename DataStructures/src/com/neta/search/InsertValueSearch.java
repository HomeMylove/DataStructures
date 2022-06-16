package com.neta.search;

/**
 * 插值查找
 */
public class InsertValueSearch {
    static int count = 0;

    public static void main(String[] args) {
        int[] arr = new int[100];
        for(int i = 0; i < arr.length;i++){
            arr[i] = i;
        }
        int index = insertValueSearch(arr, 0, arr.length - 1, 45);
        System.out.println("index="+index);


    }

    public static int insertValueSearch(int[] arr,int left,int right,int val){
        // 优化
        System.out.println("查找"+ ++count+"次");
        if(left > right || val < arr[0] || val > arr[arr.length-1]){
            return -1;
        }
        // 求出 mid
        int mid = left + (right - left) * (val - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if(val > midVal){
            return insertValueSearch(arr,mid+1,right,val);
        }else if(val < midVal){
            return insertValueSearch(arr,left,mid-1,val);
        }else {
            return mid;
        }
    }
}
