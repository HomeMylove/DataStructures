package com.neta.recursion;

/**
 * 八皇后
 */
public class Queen8 {

    // 定义一个 max 表示有多少个皇后
    int max = 8;
    //定义数组 array, 保存皇后位置
    int[] array = new int[max];

    static int count = 0;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println("count="+count);
    }


    public void check(int n){
        if(n == max){
            System.out.println("===============");
            count++;
            print();

            return;
        }
        // 依次放
        for(int i = 0; i < max; i++){
            // 先放到第一列
            array[n] = i;
            if(judge(n)){
                // 不冲突
                check(n+1);
            }
            // 冲突会继续放到后面去
        }
    }

    // 检测冲突
    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    // 输出皇后摆放的位置
    public void print() {
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
