package com.demo.no00;

import java.util.Arrays;

/**
 * leetcode 34 在排序数组中查找元素的第一个和最后一个位置
 */
public class No34_1 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int i = search(nums, target, 0, nums.length);
        int j = search(nums, target + 1, 0, nums.length);
        return (i >= nums.length || nums[i] != target) ? new int[]{-1, -1} : new int[]{i, j - 1};
    }


    public int search(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        while (start < end) {
            int mid = (start + end) / 2;
            if (target <= nums[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }


    public static void main(String[] args) {
        No34_1 no34_1 = new No34_1();
//        int[] range = no34_1.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
//        System.out.println(Arrays.toString(range));
        int[] range = no34_1.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);
        System.out.println(Arrays.toString(range));
    }
}
