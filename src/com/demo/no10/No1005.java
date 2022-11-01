package com.demo.no10;

import java.util.Arrays;

/**
 * 1005. K 次取反后最大化的数组和
 */
public class No1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;

        while (i < nums.length && nums[i] < 0 && k > 0) {
            nums[i] = -nums[i];
            k--;
            i++;
        }
        if (k % 2 == 1) {
            if (i >= nums.length) {
                nums[i - 1] = -nums[i - 1];
            } else {
                if (i == 0 || (nums[i] < nums[i - 1])) {
                    nums[i] = -nums[i];
                } else {
                    nums[i - 1] = -nums[i - 1];
                }
            }
        }


        return Arrays.stream(nums).sum();

    }

}
