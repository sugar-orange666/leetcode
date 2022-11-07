package com.demo.no03;

import java.util.Arrays;

/**
 * no322 零钱兑换
 */
public class No322 {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return 0;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;


        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                //不等于max的时候，才有选的必要，如果等于max,说明前面没有该方案
                //要选当前值的条件是前面dp[j-coin[i]] 必须能构造出来
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
//                System.out.println(Arrays.toString(dp));
            }
        }
        return dp[dp.length - 1] != Integer.MAX_VALUE ? dp[dp.length - 1] : -1;
    }
}
