package com.demo.no07;

/**
 * 746. 使用最小花费爬楼梯
 */
public class No746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        //length-2可以直接到
        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }

    public static void main(String[] args) {
        No746 no746 = new No746();
        System.out.println(no746.minCostClimbingStairs(new int[]{10, 15, 20}));
//        System.out.println(no746.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
