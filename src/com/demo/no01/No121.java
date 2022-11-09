package com.demo.no01;

/**
 * 121. 买卖股票的最佳时机
 */
public class No121 {
    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }


    public int maxProfit1(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        //没有完成交易，最大为0
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        No121 no121 = new No121();
//        System.out.println(no121.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(no121.maxProfit1(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(no121.maxProfit1(new int[]{7, 1, 1}));
    }
}
