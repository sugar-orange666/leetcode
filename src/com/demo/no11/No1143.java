package com.demo.no11;

import com.common.CommonArray;

/**
 * 1143. 最长公共子序列
 */
public class No1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        dp[0][0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }
//        CommonArray.printArray(dp);
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        No1143 no1143 = new No1143();
        System.out.println(no1143.longestCommonSubsequence("abcde", "ace"));
        System.out.println(no1143.longestCommonSubsequence("abc", "abc"));
        System.out.println(no1143.longestCommonSubsequence("abc", "def"));
    }
}
