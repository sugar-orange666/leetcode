package com.demo.no01;

import com.common.ArrayCommon;

/**
 * 123. 买卖股票的最佳时机 III
 */
public class No123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        //5个状态，0表示未操作，1表示买入，2表示卖出 3表示第二次买入，4表示第二次卖出
        int[][] dp = new int[prices.length][5];
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            //第一次买入股票和没有操作的最大值
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            //不操作，第一次卖出的最大值
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            //不操作，第二次买入的最大值
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.printf(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        return dp[dp.length - 1][4];

    }



    public static void main(String[] args) {
        No123 no123 = new No123();
        System.out.println(no123.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(no123.maxProfit(new int[]{1, 2, 3, 4, 5}));
//        System.out.println(no123.maxProfit(new int[]{7, 6, 4, 3, 1}));

    }
}
