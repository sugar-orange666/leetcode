package com.demo.no00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No51 {
    public List<String> path = new ArrayList<>();
    public List<List<String>> result = new ArrayList<>();
    char[][] flag;

    public List<List<String>> solveNQueens(int n) {
        path.clear();
        result.clear();

        flag = new char[n + 1][n + 1];

        for (int i = 0; i < flag.length; i++) {
            for (int j = 0; j < flag[0].length; j++) {
                flag[i][j] = '.';
            }
        }
        backTracing(n, 1);
        System.out.println("size:" + result.size());
        return result;
    }

    public void backTracing(int n, int curRow) {

        if (curRow == n + 1) {
            result.add(transformList());
        }

        for (int j = 1; j <= n; j++) {
            if (isValid(curRow, j, n)) {
                flag[curRow][j] = 'Q';
                backTracing(n, curRow + 1);
                flag[curRow][j] = '.';
            }
        }


    }

    public List<String> transformList() {
        List<String> list = new ArrayList<>();
        for (int i = 1; i < flag.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 1; j < flag[0].length; j++) {
                stringBuilder.append(flag[i][j]);
            }
            list.add(stringBuilder.toString());
        }

        return list;
    }


    public boolean isValid(int curRow, int j, int n) {
        for (int row = 1; row <= curRow; row++) {
            if (flag[row][j] == 'Q') {
                return false;
            }
        }

        for (int i = curRow - 1, k = j - 1; i > 0 && k > 0; i--, k--) {
            if (flag[i][k] == 'Q') {
                return false;
            }
        }

        for (int i = curRow - 1, k = j + 1; i > 0 && k <= n; i--, k++) {
            if (flag[i][k] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No51 no51 = new No51();
        System.out.println(no51.solveNQueens(5));
//        System.out.println(no51.solveNQueens(5).size());
//        System.out.println(no51.solveNQueens(4));
    }
}
