package com.demo.no00;

import java.util.Arrays;

public class No37 {


    int[][] column = new int[][]{};
    int[][] row = new int[][]{};
    int[][] grid = new int[][]{};

    boolean flag = false;

    public void solveSudoku(char[][] board) {
        initArray(board);
        backTracing(board);

    }


    public boolean backTracing(char[][] board) {


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {


                if (board[i][j] != '.') {
                    continue;
                }

                for (int k = 1; k <=9; k++) {
                    if (row[i][k] == 0 && column[j][k] == 0 && grid[((i / 3) * 3) + (j / 3)][k] == 0) {
                        board[i][j] = (char) (k + '0');
                        row[i][k] = 1;
                        column[j][k] = 1;
                        grid[((i / 3) * 3) + (j / 3)][k] = 1;

                        if (backTracing(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                        row[i][k] = 0;
                        column[j][k] = 0;
                        grid[((i / 3) * 3) + (j / 3)][k] = 0;


                    }

                }
                return false;

            }
        }
        return true;

    }

    public void initArray(char[][] board) {
        column = new int[board.length][board.length + 1];
        row = new int[board.length][board.length + 1];
        grid = new int[board.length][board.length + 1];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {

                if (board[i][j] != '.') {
                    int a = board[i][j] - '0';
                    row[i][a] = 1;
                    column[j][a] = 1;
                    grid[((i / 3) * 3) + (j / 3)][a] = 1;

                }

            }
        }


    }

    public void print(char[][] chars) {
        for (char[] aChar : chars) {
            System.out.println(Arrays.toString(aChar));
        }
    }

    public static void main(String[] args) {

        No37 no37 = new No37();
        char[][] chars = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};


        no37.solveSudoku(chars);
        no37.print(chars);

    }
}
