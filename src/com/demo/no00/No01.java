package com.demo.no00;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * no01 两数之和
 */
public class No01 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        No01 no01 = new No01();
//        int[] ints = no01.twoSum(new int[]{2,7,11,15}, 9);
        int[] ints = no01.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(Arrays.toString(ints));
        ints = no01.twoSum(new int[]{3,3}, 6);
        System.out.println(Arrays.toString(ints));
    }
}
