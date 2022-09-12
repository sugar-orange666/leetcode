package com.demo.no00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class No47 {

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    boolean[] flag;

    public List<List<Integer>> permuteUnique(int[] nums) {
        path.clear();
        result.clear();
        flag = new boolean[nums.length];
        Arrays.fill(flag, false);
        backTracing(nums);
        return result;
    }

    public void backTracing(int[] nums) {
        if (path.size() >= nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (flag[i] || set.contains(nums[i])) {
                continue;
            }

            flag[i] = true;
            path.add(nums[i]);
            set.add(nums[i]);
            backTracing(nums);
            flag[i] = false;
            path.remove(path.size() - 1);
        }


    }

    public static void main(String[] args) {
        No47 no47 = new No47();
        System.out.println(no47.permuteUnique(new int[]{1, 1, 2}));
        System.out.println(no47.permuteUnique(new int[]{1, 2, 3}));
    }
}
