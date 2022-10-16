package com.demo.no00;

public class No27_1 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[temp++] = nums[i];
            }
        }
        return temp;
    }
}
