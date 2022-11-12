package com.demo.no05;

import com.common.CommonArray;

import java.util.Arrays;

/**
 * 516. 最长回文子序列
 */
public class No516 {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
//        Arrays.fill(dp, 0);
        for (int i = dp.length - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < dp[0].length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], Math.max(dp[i][j], dp[i][j - 1]));
                }
            }
        }
//        CommonArray.printArray(dp);
        return dp[0][dp[0].length - 1];
    }


    public static void main(String[] args) {
        No516 no516 = new No516();
        System.out.println(no516.longestPalindromeSubseq("bbbab"));
        System.out.println(no516.longestPalindromeSubseq("cbbd"));
    }
}
