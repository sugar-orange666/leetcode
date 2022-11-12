package com.demo.no10;

import com.common.CommonArray;

/**
 * 1035. 不相交的线
 */
public class No1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        dp[0][0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
//        CommonArray.printArray(dp);
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        No1035 no1035 = new No1035();
        System.out.println(no1035.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
        System.out.println(no1035.maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
        System.out.println(no1035.maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}));
    }
}
