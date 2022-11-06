package com.demo.no04;

import java.util.Arrays;

/**
 * 494. 目标和
 */
public class No494 {
    //根据推导可知，left=(target+sum)/2,等式右边可以算出来，题目变为从数组中寻找和为left的值
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = Arrays.stream(nums).sum();
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        int left = (sum + target) / 2;
        //target的范围有可能为负
        if (left < 0) {
            return 0;
        }

        int[] dp = new int[left + 1];
        //dp 0号位置，要初始化为1，如果是0的话，递归结果都是0
        dp[0] = 1;
//        Arrays.fill(dp, 0);
        for (int i = 0; i < nums.length; i++) {
            for (int j = left; j >= nums[i]; j--) {
                //注意：本题目是求解所有的和(组合问题)，所以需要累加，不是求最大值
                //其中dp表示，装满j的时候，最大有多少种装法
                dp[j] += dp[j - nums[i]];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        No494 no494 = new No494();
        System.out.println(no494.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
//        System.out.println(no494.findTargetSumWays(new int[]{1, 1, 1}, 1));
//        System.out.println(no494.findTargetSumWays(new int[]{1}, 1));
    }
}
