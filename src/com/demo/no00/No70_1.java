package com.demo.no00;

/**
 * 70 爬楼梯
 */
public class No70_1 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        int[] num = new int[]{1, 2};
        dp[0] = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < num.length; j++) {
                if (i >= num[j]) {
                    dp[i] += dp[i - num[j]];
                }
            }
        }
        return dp[dp.length - 1];
    }
}
