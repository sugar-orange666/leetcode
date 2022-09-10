package com.demo.no04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class No491_2 {

    public List<Integer> path = new ArrayList<>();
    public List<List<Integer>> result = new ArrayList<>();


    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracing(nums, 0);
        return result;
    }

    public void backTracing(int[] nums, int startIndex) {
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }

        if (startIndex >= nums.length) {
            return;
        }

        int[] flag = new int[201];
        Arrays.fill(flag,0);
        for (int i = startIndex; i < nums.length; i++) {
            if (flag[nums[i] + 100] == 1
                    || (path.size() > 0 && nums[i] < path.get(path.size() - 1))) {
                continue;
            }

            flag[nums[i] + 100] = 1;
            path.add(nums[i]);
            backTracing(nums, i + 1);
            //不回溯
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        No491_2 no491 = new No491_2();
        System.out.println(no491.findSubsequences(new int[]{4, 6, 7, 7}));
    }
}
