package com.demo.no00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * no18 四数之和
 */
public class No18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int p1 = 0; p1 < nums.length; p1++) {
            if (p1 != 0 && nums[p1] == nums[p1 - 1]) {
                continue;
            }
            for (int p2 = p1 + 1; p2 < nums.length; p2++) {
                if (p2 != p1 + 1 && nums[p2] == nums[p2 - 1]) {
                    continue;
                }
                long temp = (target - (long) (nums[p1] + nums[p2]));
                for (int left = p2 + 1, right = nums.length - 1; left < right; ) {
                    if (left != p2 + 1 && nums[left] == nums[left - 1]) {
                        left++;
                        continue;
                    }
                    if (right != nums.length - 1 && nums[right] == nums[right + 1]) {
                        right--;
                        continue;
                    }


                    if ((long) (nums[left] + nums[right]) == temp) {
                        res.add(Arrays.asList(nums[p1], nums[p2], nums[left], nums[right]));
                        left++;
                    } else if ((long) (nums[left] + nums[right]) < temp) {
                        left++;
                    } else {
                        right--;
                    }

                }

            }
        }

        return res;
    }

    public static void main(String[] args) {
        No18 no18 = new No18();
//        List<List<Integer>> list = no18.fourSum(new int[]{2,2,2,2}, 8);
//        List<List<Integer>> list = no18.fourSum(new int[]{1,0,-1,0,-2,2}, 0);
//        List<List<Integer>> list = no18.fourSum(new int[]{2, 2, 2, 2, 2}, 8);
        List<List<Integer>> list = no18.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296);
        System.out.println(list);
    }
}
