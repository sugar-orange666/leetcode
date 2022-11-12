package com.demo.no05;

import com.common.CommonArray;

/**
 * 583. 两个字符串的删除操作
 */
public class No583 {
    public int minDistance(String word1, String word2) {
        //先求两个字符串的最长公共子串的长度
        int res = maxSubStringLength(word1, word2);
//        System.out.println("maxSubStringLength:" + res);
        return (word1.length() - res) + (word2.length() - res);
    }

    public int maxSubStringLength(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        dp[0][0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
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
        No583 no583 = new No583();
        System.out.println(no583.minDistance("sea", "eat"));
        System.out.println(no583.minDistance("leetcode", "etco"));
    }
}
