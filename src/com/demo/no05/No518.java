package com.demo.no05;

import java.util.Arrays;

/**
 * 518. 零钱兑换 II
 */
public class No518 {
    public int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                //求方案问题要用累加
                dp[j] = dp[j] + dp[j - coins[i]];
            }
//            System.out.println(Arrays.toString(dp));
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        No518 no518 = new No518();
        System.out.println(no518.change(5, new int[]{1, 2, 5}));
    }
}
