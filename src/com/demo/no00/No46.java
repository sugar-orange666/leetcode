package com.demo.no00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列
 */
public class No46 {

    public List<Integer> path = new ArrayList<>();
    public List<List<Integer>> result = new ArrayList<>();
    int[] flag = new int[21];

    public List<List<Integer>> permute(int[] nums) {
        path.clear();
        result.clear();
        backTracing(nums);

        return result;
    }

    public void backTracing(int[] nums) {
        if (path.size() >= nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            if (flag[nums[i] + 10] == 1) {
                continue;
            }
            flag[nums[i] + 10] = 1;
            path.add(nums[i]);
            backTracing(nums);
            flag[nums[i] + 10] = 0;
            path.remove(path.size() - 1);
        }


    }

    public static void main(String[] args) {
        No46 no46 = new No46();
        System.out.println(no46.permute(new int[]{1, 2, 3}));
        System.out.println(no46.permute(new int[]{0, 1}));
        System.out.println(no46.permute(new int[]{1}));
    }
}
