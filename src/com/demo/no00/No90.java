package com.demo.no00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No90 {

    public List<Integer> path = new ArrayList<>();
    public List<List<Integer>> result = new ArrayList<>();

    public boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        path.clear();
        result.clear();
        //需要排序，才能知道上一个是否被重复选取过
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backTracing(nums, 0);
        Arrays.fill(used, false);
        return result;
    }

    public void backTracing(int[] nums, int startIndex) {

        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            //注意这里 use[i-1]=false，说明前面已经回溯完了，当前是层级遍历
            // use[i]=true，说明是深度遍历
            if (i != 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backTracing(nums, i + 1);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }



    public static void main(String[] args) {
        No90 no90 = new No90();
        System.out.println(no90.subsetsWithDup(new int[]{1, 2, 2}));
        System.out.println(no90.subsetsWithDup(new int[]{0}));
    }
}
