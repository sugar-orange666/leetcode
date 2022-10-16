package com.demo.no09;

import java.util.Arrays;

public class No977_1 {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0, j = nums.length - 1, pos = nums.length - 1; i<=j; ) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                arr[pos--] = nums[i] * nums[i];
                i++;
            } else {
                arr[pos--] = nums[j] * nums[j];
                j--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        No977_1 no977_1 = new No977_1();
        int[] res = no977_1.sortedSquares(new int[]{-7,-3,2,3,11});
//        int[] res = no977_1.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Arrays.toString(res));
    }
}
