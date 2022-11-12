package com.demo.no03;

import com.common.CommonArray;

import java.util.Arrays;

/**
 * 392. 判断子序列
 */
public class No392 {
    public boolean isSubsequence(String s, String t) {
        if ((s == null || s.length() == 0) && (t == null || t.length() == 0)) {
            return true;
        }
        if (s == null || s.length() == 0) {
            return true;
        }
        if (t == null || t.length() == 0) {
            return false;
        }

        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
        dp[0][0] = true;
        Arrays.fill(dp[0], true);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.printf(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        return dp[dp.length - 1][dp[0].length - 1];
    }


    public static void main(String[] args) {
        No392 no392 = new No392();
        System.out.println(no392.isSubsequence("abc", "ahbgdc"));
        System.out.println(no392.isSubsequence("axc", "ahbgdc"));
        System.out.println(no392.isSubsequence("b", "abc"));
    }
}
