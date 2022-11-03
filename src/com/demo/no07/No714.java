package com.demo.no07;

/**
 * 714. 买卖股票的最佳时机含手续费
 */
public class No714 {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int buy = prices[0] + fee;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            }
            if (prices[i] > buy) {
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        No714 no714 = new No714();
        System.out.println(no714.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(no714.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3));
    }
}
