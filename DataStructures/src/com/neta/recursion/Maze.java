package com.neta.recursion;

/**
 * 迷宫
 */
public class Maze {
    public static void main(String[] args) {
        // 创建一个二维数组，模拟迷宫
        // 地图
        int[][] map = new int[8][7];
        // 使用 1 表示墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        // 设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        map[5][2] = 1;
        map[5][3] = 1;
        map[5][4] = 1;
        map[5][5] = 1;

        setWay(map,1,1);

        showMap(map);



    }
    // 使用递归给小球找路


    /**
     * @param map 地图
     * @param i   从哪里开始
     * @param j   从哪里开始
     * @return 是否找到
     * 约定
     * i,j 从哪儿开始
     * 找到[5][6] 成功
     * 0 表示没走，1表示强，2表示可以走，3表示已经走过
     * 策略 下 => 右 => 上 => 左
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;  // 通了
        } else {
            if (map[i][j] == 0) {  // 没有走过，按策略走
                map[i][j] = 2; // 假定可以走
                if (setWay(map, i + 1, j)) {  // 向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    // 走不通
                    map[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }


    public static void showMap(int[][] map) {
        for (int[] rows : map) {
            for (int i : rows) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }


    }
}
