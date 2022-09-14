package com.demo.no00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No51_2 {


    public List<List<String>> result = new ArrayList<>();
    int[] left;
    int[] right;
    int[] column;
    int[] queen;

    public List<List<String>> solveNQueens(int n) {
        result.clear();
        left = new int[2 * n - 1];
        right = new int[2 * n - 1];
        column = new int[n];
        queen = new int[n];
        Arrays.fill(left, 0);
        Arrays.fill(right, 0);
        Arrays.fill(column, 0);
        Arrays.fill(queen, 0);
        backTracing(n, 0);
        return result;
    }


    public void backTracing(int n, int row) {
        if (row == n ) {
            result.add(getArrayList(n));
            return;
        }

        for (int j = 0; j < n; j++) {

            if (column[j] == 0 && left[row + j] == 0 && right[n - 1 + row - j] == 0) {
                queen[row] = j;
                column[j] = 1;
                left[row + j] = 1;
                right[n - 1 + row - j] = 1;
                backTracing(n, row + 1);
                queen[row] = 0;
                column[j] = 0;
                left[row + j] = 0;
                right[n - 1 + row - j] = 0;
            }
        }
    }

    public List<String> getArrayList(int n) {
        List<String> list = new ArrayList<>();
        for (int k : queen) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < queen.length; j++) {
                if (j == k) {
                    stringBuilder.append("Q");
                } else {
                    stringBuilder.append(".");
                }
            }

            list.add(stringBuilder.toString());
        }
        return list;
    }


    public static void main(String[] args) {
        No51_2 no51_2 = new No51_2();
        System.out.println(no51_2.solveNQueens(5));
        System.out.println(no51_2.solveNQueens(5).size());
    }
}
