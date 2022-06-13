package com.neta.sparsearray;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SparseArray {
    public static void main(String[] args){
        // 创建原始的二维数组
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

        // 输出原始数组
        System.out.println("==========原始的:==========");
        printChess(chessArr1);

        // 遍历二维数组，得到非 0 的个数
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                }
            }
        }

        // 创建对应的稀疏数组
        int[][] sparseArr = new int[count + 1][3];
        // 给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = count;

        // 遍历二维数组，将非 0 的值存入稀疏数组
        int index = 1;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sparseArr[index][0] = i;
                    sparseArr[index][1] = j;
                    sparseArr[index][2] = chessArr1[i][j];
                    index++;
                }
            }
        }

        System.out.println("==========稀疏数组:==========");
        printChess(sparseArr);
        // 存盘
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("src\\map.data"));
            oos.writeObject(sparseArr);
            System.out.println("保存成功");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            assert oos != null;
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        // 恢复
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for(int i = 1; i < sparseArr.length; i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("==========恢复:==========");
        printChess(chessArr2);
    }

    public static void printChess(int[][] chess) {
        for (int[] row : chess) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}
