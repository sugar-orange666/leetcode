package com.demo.no00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 */
public class No15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);


        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            for (int left = i + 1, right = nums.length - 1; left < right; ) {

                if (left != i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                if (right != nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }
                if (nums[left] + nums[right] == target) {
                    List<Integer> cur = Arrays.asList(nums[i], nums[left], nums[right]);
                    res.add(cur);
                    left++;
                }
                if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }


        }
        return res;
    }

    public static void main(String[] args) {
        No15 no15 = new No15();
        System.out.println(no15.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
