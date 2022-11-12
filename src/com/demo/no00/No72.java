package com.demo.no00;

import com.common.CommonArray;

/**
 * 72. 编辑距离
 */
public class No72 {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        dp[0][0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }
//        CommonArray.printArray(dp);
        return dp[dp.length - 1][dp[0].length - 1];
    }


    public static void main(String[] args) {
        No72 no72 = new No72();
//        System.out.println(no72.minDistance("horse", "ros"));
        System.out.println(no72.minDistance("horse", "ros"));
//        System.out.println(no72.minDistance("intention", "execution"));
    }
}
