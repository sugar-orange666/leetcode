package com.demo.no02;

import java.util.Arrays;

/**
 * 213. 打家劫舍 II
 */
public class No213 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(funRob(nums, 0, nums.length - 2),
                funRob(nums, 1, nums.length - 1));
    }

    public int funRob(int[] nums, int start, int end) {

        if (start == end) {
            return nums[start];
        }
        if (end - start == 1) {
            return Math.max(nums[start], nums[end]);
        }
        //这里的dp数组也可以直接申请和nums一样大的空间
        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(nums[i + start] + dp[i - 2], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }


    public static void main(String[] args) {
        No213 no213 = new No213();
//        System.out.println(no213.rob(new int[]{2, 3, 2}));
//        System.out.println(no213.rob(new int[]{1, 2, 3, 1}));
        System.out.println(no213.rob(new int[]{1, 2, 1, 0}));
//        System.out.println(no213.rob(new int[]{1, 2, 3}));
    }
}
