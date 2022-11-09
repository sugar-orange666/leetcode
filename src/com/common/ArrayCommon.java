package com.common;

public class ArrayCommon {
    /**
     * 二维数组输出
     *
     * @param array array
     */
    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.printf(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
