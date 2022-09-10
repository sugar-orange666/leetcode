package com.demo.no00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 */
public class No39 {

    public LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // 先进行排序
        backTracing(candidates, target, 0, 0);
        return result;
    }

    public void backTracing(int[] candidates, int target, int sum, int curIndex) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }


        for (int i = curIndex; i < candidates.length; i++) {
            if (sum > target) {
                break;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            backTracing(candidates, target, sum, i);
            path.removeLast();
            sum -= candidates[i];
        }
    }


    public static void main(String[] args) {
        No39 no39 = new No39();
        System.out.println(no39.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(no39.combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(no39.combinationSum(new int[]{2}, 1));
    }
}
