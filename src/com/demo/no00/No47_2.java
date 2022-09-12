package com.demo.no00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No47_2 {

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        path.clear();
        result.clear();
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backTracing(nums);
        return result;
    }

    public void backTracing(int[] nums) {

        if (path.size() >= nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backTracing(nums);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        No47_2 no47_2 = new No47_2();
        System.out.println(no47_2.permuteUnique(new int[]{1, 1, 2}));
//        System.out.println(no47_2.permuteUnique(new int[]{1, 2, 3}));
    }
}
