package com.demo.no01;

/**
 * 188. 买卖股票的最佳时机 IV
 */
public class No188 {
    public int maxProfit(int k, int[] prices) {
        int[] arr = new int[2 * k + 1];
        for (int i = 1; i < arr.length; i++) {
            if (i % 2 == 1) {
                arr[i] = -prices[0];
            } else {
                arr[0] = 0;
            }
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                //买入
                if (j % 2 == 1) {
                    arr[j] = Math.max(arr[j], arr[j - 1] - prices[i]);
                } else {
                    arr[j] = Math.max(arr[j], arr[j - 1] + prices[i]);
                }
            }
        }
        return arr[arr.length - 1];
    }

}
