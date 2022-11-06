package com.demo.no10;

import java.util.Arrays;

/**
 * 1049. 最后一块石头的重量 II
 */
public class No1049 {
    public int lastStoneWeightII(int[] stones) {
        if (stones == null || stones.length == 0) {
            return 0;
        }
        if (stones.length == 1) {
            return stones[0];
        }
        int sum = Arrays.stream(stones).sum();
        int weight = sum % 2 == 1 ? (sum / 2) + 1 : sum / 2;

        int[] dp = new int[weight + 1];
        int curMax = Integer.MIN_VALUE;
        for (int i = 0; i < stones.length; i++) {
            for (int j = weight; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
                curMax = Math.max(curMax, dp[j]);
            }
        }

//        System.out.println("curMax=" + curMax + ",another=" + Math.abs(sum - curMax));
        return Math.abs(curMax - (sum - curMax));
    }

    public static void main(String[] args) {
        No1049 no1049 = new No1049();
        System.out.println(no1049.lastStoneWeightII(new int[]{}));
        System.out.println(no1049.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(no1049.lastStoneWeightII(new int[]{31, 26, 33, 21, 40}));
    }
}
