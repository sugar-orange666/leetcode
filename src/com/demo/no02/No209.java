package com.demo.no02;

/**
 * 209. 长度最小的子数组
 */
public class No209 {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                res = Math.min(res, j - i + 1);
                sum -= nums[i];
                i++;
            }

        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        No209 no209 = new No209();
//        int[] arr = new int[]{2, 3, 1, 2, 4, 3};
//        int res = no209.minSubArrayLen(7, arr);
        int[] arr1 = new int[]{1, 4, 4};
        int res1 = no209.minSubArrayLen(4, arr1);
        int[] arr2 = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        int res2 = no209.minSubArrayLen(11, arr2);
        System.out.println(res1);
        System.out.println(res2);
    }
}
