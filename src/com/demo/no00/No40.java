package com.demo.no00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No40 {

    public List<Integer> path = new ArrayList<>();
    public List<List<Integer>> result = new ArrayList<>();

    public Boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new Boolean[candidates.length];
        for (int i = 0; i < used.length; i++) {
            used[i] = false;
        }
        backTracing(candidates, target, 0, 0);

        return result;
    }

    public void backTracing(int[] candidates, int target, int sum, int startIndex) {
        if (target == sum) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i != 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }

            if (sum > target) {
                break;
            }
            sum += candidates[i];
            used[i] = true;
            path.add(candidates[i]);
            backTracing(candidates, target, sum, i + 1);
            sum -= candidates[i];
            path.remove(path.size() - 1);
            used[i] = false;
        }


    }

    public static void main(String[] args) {
        No40 no40 = new No40();
        System.out.println(no40.combinationSum2(new int[]{2, 2, 2}, 2));
//        System.out.println(no40.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
