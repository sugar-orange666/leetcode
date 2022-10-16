package com.demo.no09;

import java.util.Arrays;

/**
 * 有序数组的平方
 */
public class No977 {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums ;
    }
}
