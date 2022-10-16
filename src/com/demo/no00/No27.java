package com.demo.no00;

/**
 * 27. 移除元素
 */
public class No27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int p1 = 0, p2 = 0;
        while (p1 < nums.length && p2 < nums.length) {
            while (p2 < nums.length && val == nums[p2]) {
                p2++;
            }
            if (p2 < nums.length && p1 != p2) {
                nums[p1] = nums[p2];
            }
            if (p2 < nums.length) {
                p1++;
            }
            p2++;
        }

        return p1;
    }

    public static void main(String[] args) {
        No27 no27 = new No27();
        int[] arr = new int[]{3, 2, 2, 3};
//        int[] arr = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int element = no27.removeElement(arr, 3);
        System.out.println(element);
    }
}
