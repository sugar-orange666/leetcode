package com.demo.no02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * no279 完全平方数
 */
public class No279 {
    public int numSquares(int n) {

        List<Integer> list = new ArrayList<>();
        int index = 1;
        while (true) {
            if ((index * index) <= n) {
                list.add(index * index);
                index++;
            } else {
                break;
            }
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int[] nums = list.stream().mapToInt(Integer::valueOf).toArray();
        // System.out.println(Arrays.toString(nums));
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j < dp.length; j++) {
                if (dp[j - nums[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - nums[i]] + 1);
                }
            }
//            System.out.println(Arrays.toString(dp));
        }

        return dp[dp.length - 1] == Integer.MAX_VALUE ? 0 : dp[dp.length - 1];
    }
}
