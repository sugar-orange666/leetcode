package com.demo.no07;

import java.util.Arrays;

/**
 * 718. 最长重复子数组
 */
public class No718_1 {
    public int findLength(int[] nums1, int[] nums2) {
        int res = 0;
        int[] dp = new int[nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = nums2.length; j > 0; j--) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                } else {
                    dp[j] = 0;
                }
                res = Math.max(res, dp[j]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }

    public static void main(String[] args) {
        No718_1 no718 = new No718_1();
        System.out.println(no718.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        System.out.println(no718.findLength(new int[]{3, 2, 1, 4, 7}, new int[]{1, 2, 3, 2, 1}));
    }
}
