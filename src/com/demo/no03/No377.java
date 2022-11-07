package com.demo.no03;

/**
 * 377 组合总和 Ⅳ
 */
public class No377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
//            System.out.println(Arrays.toString(dp));
        }

        return dp[dp.length - 1];

    }
}
