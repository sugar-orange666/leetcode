package com.demo.no00;

/**
 * 62. 不同路径
 */
public class No62 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //第一行初始值赋值为1

//        System.out.println(dp.length);
//        System.out.println(dp[0].length);
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        //第一列初始值赋值为1
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }

        //当前的值等于左边+上边的值
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        //返回右下角的值
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        No62 no62 = new No62();
        System.out.println(no62.uniquePaths(3, 7));
        System.out.println(no62.uniquePaths(3, 2));
        System.out.println(no62.uniquePaths(7, 3));
        System.out.println(no62.uniquePaths(3, 3));
    }
}
