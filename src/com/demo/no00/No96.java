package com.demo.no00;

import java.util.Arrays;

/**
 * 96.不同的二叉搜索树
 */
public class No96 {

    public int numTrees(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //左右子树的可能性之和
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
//        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        No96 no96 = new No96();
        System.out.println(no96.numTrees(3));
//        System.out.println(no96.numTrees(1));
//        System.out.println(no96.numTrees(4));
    }
}
