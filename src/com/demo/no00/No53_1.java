package com.demo.no00;

import java.util.Arrays;

/**
 * 53. 最大子序和
 */
public class No53_1 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(res, dp[i]);
        }
//        System.out.println(Arrays.toString(dp));
        return res;
    }

    public static void main(String[] args) {
        No53_1 no53_1 = new No53_1();
//        System.out.println(no53_1.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
//        System.out.println(no53_1.maxSubArray(new int[]{1}));
        System.out.println(no53_1.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}
