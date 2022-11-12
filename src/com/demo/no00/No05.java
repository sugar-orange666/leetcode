package com.demo.no00;

import com.common.CommonArray;

import java.util.Arrays;

/**
 * 5. 最长回文子串
 */
public class No05 {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int maxIndexI = -1;
        int maxIndexJ = -1;
        int maxLength = 0;

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = i; j < dp[0].length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;

                    } else if (dp[i + 1][j - 1]) {
                        //剩余区间是否为回文串
                        dp[i][j] = true;
                    }
                    if (dp[i][j] && j - i + 1 > maxLength) {
                        maxLength = Math.max(maxLength, j - i + 1);
                        maxIndexI = i;
                        maxIndexJ = j;

                    }
                }
            }
        }

//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.printf(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//
//        System.out.println(maxIndexI);
//        System.out.println(maxIndexJ);


        return (maxIndexI == -1 || maxIndexJ == -1) ? "" : s.substring(maxIndexI, maxIndexJ + 1);
    }

    public static void main(String[] args) {
        No05 no05 = new No05();
//        System.out.println(no05.longestPalindrome("babad"));
//        System.out.println(no05.longestPalindrome("cbbd"));
        System.out.println(no05.longestPalindrome("aacabdkacaa"));
//        System.out.println(no05.longestPalindrome("kacaa"));
    }
}
