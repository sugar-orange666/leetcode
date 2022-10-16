package com.demo.no00;

import java.util.Arrays;


/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class No34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int mid = 0;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        if (low > high) {
            return new int[]{-1, -1};
        }

        System.out.println("mid:" + mid);
        //找到元素的位置
        int end = mid;
        for (int i = mid; i < nums.length; i++) {
            if (nums[i] != target) {
                break;
            } else {
                end = i;
            }
        }
        int start = mid;
        for (int i = mid - 1; i >= 0; i--) {
            if (nums[i] != target) {
                break;
            } else {
                start = i;
            }

        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1};
        int[] arr = new int[]{5, 7, 7, 8, 8, 10};
        No34 no34 = new No34();
        System.out.println(Arrays.toString(no34.searchRange(arr, 8)));
        System.out.println(Arrays.toString(no34.searchRange(arr, 6)));
        System.out.println(Arrays.toString(no34.searchRange(new int[]{}, 0)));
    }
}
