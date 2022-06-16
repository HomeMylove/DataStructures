package com.neta.recursion;

public class EightQueen {
    public static void main(String[] args) {

        ChessMap map = new ChessMap();
        for (int i = 0; i < 8; i++) {
            solve(map, 0, i);
        }

        System.out.println("count=" + ChessMap.count);

    }

    public static boolean solve(ChessMap map, int x, int y) {
        if (map.isSolved()) {
            System.out.println("=================================");
            map.showMap();
            ChessMap.count++;
            return true;
        } else {
            if (map.setMap(x, y)) {
                boolean flag = false;
                for (int i = 0; i < 8; i++) {
                    if (solve(map, x + 1, i)) {
                        flag = true;
                        if (x + 1 == 8) {
                            break;
                        }
                    }
                }
                map.clearMap(x, y);
                return flag;
            } else {
                return false;
            }
        }
    }
}

class ChessMap {
    private final int[][] map = new int[8][8];
    public static int count = 0;

    public void clearMap(int x, int y) {
        map[x][y] = 0;
    }

    public boolean setMap(int x, int y) {
        // 落子之前看看能不能下
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    if (i == x || j == y || (x - i) == (y - j) || (x - i) == (j - y)) {
                        return false;
                    }
                }
            }
        }
        map[x][y] = 1;
        return true;
    }

    public boolean isSolved() {
        int count = 0;
        for (int[] rows : map) {
            for (int i : rows) {
                if (i == 1) {
                    count++;
                }
            }
        }
        return count == 8;
    }

    public void showMap() {
        for (int[] rows : map) {
            for (int i : rows) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
    }

}
