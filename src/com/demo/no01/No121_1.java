package com.demo.no01;

import java.util.Arrays;

/**
 * 121. 买卖股票的最佳时机 I
 */
public class No121_1 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            //当前持有的最大现金
            dp[i][0] = Math.max(-prices[i], dp[i - 1][0]);

            //当前不持有的最大现金
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
        }


        return dp[dp.length - 1][1];
    }

    public static void main(String[] args) {
        No121_1 no121_1 = new No121_1();
        System.out.println(no121_1.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
