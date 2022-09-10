package com.demo.no00;

import java.util.ArrayList;
import java.util.List;

public class No78 {

    public List<Integer> path = new ArrayList<>();
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        path.clear();
        result.clear();
        backTracing(nums, 0);
        return result;
    }

    public void backTracing(int[] nums, int startIndex) {

        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTracing(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        No78 no78 = new No78();
        System.out.println(no78.subsets(new int[]{1, 2, 3}));
        System.out.println(no78.subsets(new int[]{0}));
    }
}
