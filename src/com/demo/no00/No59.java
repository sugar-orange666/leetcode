package com.demo.no00;

import java.util.Arrays;

/**
 * 59. 螺旋矩阵 II
 */
public class No59 {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[][]{};
        }
        int curNum = 1;
        int[][] res = new int[n][n];
        int startI = 0, endI = n - 1;
        int startJ = 0, endJ = n - 1;
        int count = n * n;

        while (startI <= endI && startJ <= endJ) {

            for (int i = startI; i <= endI && curNum <= count; i++) {
                res[startJ][i] = curNum;
                curNum++;
            }
//            System.out.println(Arrays.deepToString(res));

            for (int i = startJ + 1; i <= endJ && curNum <= count; i++) {
                res[i][endI] = curNum;
                curNum++;
            }
//            System.out.println(Arrays.deepToString(res));
            for (int i = endI - 1; i >= startI && curNum <= count; i--) {
                res[endJ][i] = curNum;
                curNum++;
            }
//            System.out.println(Arrays.deepToString(res));
            for (int i = endJ - 1; i >= startJ + 1; i--) {
                res[i][startI] = curNum;
                curNum++;

            }
//            System.out.println(Arrays.deepToString(res));
            startI++;
            endI--;
            startJ++;
            endJ--;
        }
        return res;
    }

    public static void main(String[] args) {
        No59 no59 = new No59();
        int[][] ints = no59.generateMatrix(3);
        System.out.println(Arrays.deepToString(ints));
    }
}
