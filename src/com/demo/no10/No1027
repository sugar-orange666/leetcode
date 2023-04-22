package com.demo.no10;


public class No1027 {
    public int longestArithSeqLength(int[] nums) {
        // https://leetcode.cn/problems/longest-arithmetic-subsequence/solutions/1481559/zui-chang-deng-chai-shu-lie-by-zai-jian-u21ci/?orderBy=hot
        //dp数组表示以i结尾的，公差为d的最长等差数列的长度
        int[][] dp = new int[nums.length][1001];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = 0;
            }
        }
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int d = nums[i] - nums[j] + 500;
                // 从后向前遍可能当前值会复覆盖更大的值，特殊用例[6,4,6,8].因此这里要求一个max
                dp[i][d] = Math.max(dp[i][d], dp[j][d] + 1);
                max = Math.max(max, dp[i][d]);
            }
        }
        //        CommonArray.printArray(dp);
        return max + 1;

    }


    public static void main(String[] args) {
        No1027 no1027 = new No1027();
//        System.out.println(no1027.longestArithSeqLength(new int[]{3, 6, 9, 12}));
//        System.out.println(no1027.longestArithSeqLength(new int[]{9, 4, 7, 2, 10}));
        System.out.println(no1027.longestArithSeqLength(new int[]{4, 3, 2}));

    }
}
