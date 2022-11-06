package com.demo.no04;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 */
public class No416 {
    /**
     * 01背包问题
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        //背包的容量
        int sum = Arrays.stream(nums).sum();
        //和为奇数，说明不符合条件，不能分割,直接返回
        if (sum % 2 == 1) {
            return false;
        }
        //背包的容量
        int weight = sum / 2;
        int[] dp = new int[weight + 1];
        Arrays.fill(dp, 0);
        for (int i = 0; i < nums.length; i++) {
            for (int j = weight; j >= nums[i]; j--) {
                //不放物品，与放了物品的最大值做比较
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
                //如果当前背包装满了，说明符合条件
                if (dp[j] == weight) {
                    return true;
                }
            }
//            System.out.println(Arrays.toString(dp));
        }

        return false;
    }

    public static void main(String[] args) {
        No416 no416 = new No416();
//        System.out.println(no416.canPartition(new int[]{2, 2, 3, 4, 7}));
//        System.out.println(no416.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(no416.canPartition(new int[]{1, 2, 3, 5}));
    }
}
