package com.demo.no01;

/**
 * 122. 买卖股票的最佳时机 II
 */
public class No122 {
    public int maxProfit(int[] prices) {
        int curProfit = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            curProfit = prices[i] - prices[i - 1];
            if (curProfit > 0) {
                maxProfit += curProfit;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        No122 no122 = new No122();
        System.out.println(no122.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(no122.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(no122.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
