package com.demo.no00;

/**
 * 26. 删除有序数组中的重复项
 */
public class No26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int before = Integer.MIN_VALUE;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != before) {
                before = nums[i];
                nums[temp++] = nums[i];
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{0,0,1,1,1,2,2,3,3,4};
//        int[] arr=new int[]{1,1,2};
        No26 no26=new No26();
        System.out.println(no26.removeDuplicates(arr));
    }

}
