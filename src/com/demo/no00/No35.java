package com.demo.no00;

import com.demo.no02.No236;

/**
 * 35.搜索插入位置
 */
public class No35 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length-1;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6};
        No35 no35 = new No35();
        System.out.println( no35.searchInsert(arr, 5));
        System.out.println( no35.searchInsert(arr, 2));
        System.out.println( no35.searchInsert(arr, 7));

    }
}
