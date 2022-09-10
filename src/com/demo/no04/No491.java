package com.demo.no04;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * //数组是无序的
 * 看清题目，无序且有重复，不能手动排序
 */
public class No491 {

    public List<Integer> path = new ArrayList<>();
    public List<List<Integer>> result = new ArrayList<>();


    public List<List<Integer>> findSubsequences(int[] nums) {
        path.clear();
        result.clear();

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

        HashSet<Integer> used = new HashSet<Integer>();
        for (int i = startIndex; i < nums.length; i++) {
            if (i != 0 && used.contains(nums[i])
                    || (path.size() > 0 && nums[i] < path.get(path.size() - 1))) {
                continue;
            }
            used.add(nums[i]);
            path.add(nums[i]);
            backTracing(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        No491 no491 = new No491();
        System.out.println(no491.findSubsequences(new int[]{4, 6, 7, 7}));
//        System.out.println(no491.findSubsequences(new int[]{4, 4, 3, 2, 1}));
    }
}
