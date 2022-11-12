package com.demo.no07;

/**
 * 718. 最长重复子数组
 */
public class No718 {
    public int findLength(int[] nums1, int[] nums2) {
        int res = 0;
        //以下标为i-1结尾的nums1和以下标为j-1结尾的nums2 最长重复子数组
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                //当前字母之前的是否相等
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(dp[i][j], res);
                }
            }
        }

//        System.out.println(Arrays.toString(dp));
//        ArrayCommon.printArray(dp);

        return res;
    }


    public static void main(String[] args) {
        No718 no718 = new No718();
        System.out.println(no718.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
        System.out.println(no718.findLength(new int[]{3, 2, 1, 4, 7}, new int[]{1, 2, 3, 2, 1}));
    }
}
