package com.demo.no02;

import java.util.Arrays;

/**
 * 283. 移动零
 */
public class No283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[temp++] = nums[i];
            }
        }
        for (int i = temp ; i < nums.length; i++) {
            nums[i] = 0;
        }
//        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        No283 no283 = new No283();
        no283.moveZeroes(new int[]{0, 1, 0, 3, 12});
        no283.moveZeroes(new int[]{0});
    }
}
