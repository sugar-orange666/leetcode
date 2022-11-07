package com.demo.no01;

import java.util.Arrays;

/**
 * 198. 打家劫舍
 */
public class No198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            //抢与不抢
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
//            System.out.println(Arrays.toString(dp));
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        No198 no198 = new No198();
        System.out.println(no198.rob(new int[]{1, 2, 3, 1}));
        System.out.println(no198.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
