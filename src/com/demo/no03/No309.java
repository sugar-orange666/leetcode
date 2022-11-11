package com.demo.no03;

/**
 * 309. 最佳买卖股票时机含冷冻期
 */
public class No309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        if (prices.length == 1) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[1][0] = Math.max(-prices[0], -prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0] + prices[1]);
        for (int i = 2; i < prices.length; i++) {
            //隔一天才能买入
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }

//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.printf(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        return dp[dp.length - 1][1];
    }
}

