package com.demo.no07;

public class No704 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int mid;
        int low = 0, high = nums.length - 1;
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
        return -1;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 3, 5, 9, 12};
        No704 no704 = new No704();
//        System.out.println(no704.search(arr, 9));
//        System.out.println(no704.search(arr, 9));
        System.out.println(no704.search(arr, 2));
    }
}
