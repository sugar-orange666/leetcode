package com.demo.no01;

/**
 * 122. 买卖股票的最佳时机 II
 */
public class No122_1 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            //持有股票的现金= 上一天持有股票的现金和 上一天卖出今天买入的最大值
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            //不持有股票的最大值= 上一天不持有股票 和 上一天持有股票+今天卖出的最大值
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
//        ArrayCommon.printArray(dp);
        return dp[dp.length - 1][1];
    }


    public static void main(String[] args) {
        No122_1 no122_1 = new No122_1();
        System.out.println(no122_1.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(no122_1.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(no122_1.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
