package com.demo.no00;

/**
 * no53. 最大子数组和
 */
public class No53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int curSum = nums[0];
        int maxSum = curSum;

        for (int i = 1; i < nums.length; i++) {
            if (curSum < 0 && nums[i] > curSum) {
                curSum = nums[i];
            } else {
                curSum += nums[i];
            }
            maxSum = Math.max(curSum, maxSum);

        }

        return maxSum;
    }

    public static void main(String[] args) {
        No53 no53 = new No53();
        System.out.println(no53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(no53.maxSubArray(new int[]{1}));
        System.out.println(no53.maxSubArray(new int[]{5, 4, -1, 7, 8}));
        System.out.println(no53.maxSubArray(new int[]{-2, -1}));
    }
}
