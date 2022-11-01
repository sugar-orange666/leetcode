package com.demo.no03;

import com.demo.no00.No37;

public class No376 {
    // 参考https://leetcode.cn/problems/wiggle-subsequence/solution/by-nehzil-i40t/
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        //当前差值
        int curDiff = 0;
        //上一个差值
        int preDiff = 0;
        //默认最后一个符合条件，是峰或者谷
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            if ((curDiff > 0 && preDiff <= 0) || curDiff < 0 && preDiff >= 0) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        No376 no376 = new No376();
        System.out.println(no376.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
        System.out.println(no376.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        System.out.println(no376.wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(no376.wiggleMaxLength(new int[]{3, 3, 3, 2, 5}));
    }

}
