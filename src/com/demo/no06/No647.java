package com.demo.no06;

import com.common.CommonArray;

/**
 * 647. 回文子串
 */
public class No647 {
    public int countSubstrings(String s) {
        //i到j之间的串是否为回文串
        boolean[][] dp = new boolean[s.length()][s.length()];
        int result = 0;

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = i; j < dp[0].length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        result++;
                        dp[i][j] = true;

                    } else if (dp[i + 1][j - 1]) {
                        //剩余区间是否为回文串
                        result++;
                        dp[i][j] = true;
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

        return result;
    }

    public static void main(String[] args) {
        No647 no647 = new No647();
        System.out.println(no647.countSubstrings("abc"));
        System.out.println(no647.countSubstrings("aaa"));
    }
}
