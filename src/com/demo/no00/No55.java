package com.demo.no00;

/**
 * 55. 跳跃游戏
 */
public class No55 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        if (nums.length == 1) {
            return true;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
//            System.out.println(j);
            j = Math.max(nums[i] + i, j);
            if (j >= nums.length - 1) {
                return true;
            }
            //还没有结束就无路可走
            if ( i == j && nums[j] == 0) {
                return false;
            }
        }
        return j > nums.length - 1;
    }
}
