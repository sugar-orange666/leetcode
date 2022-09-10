package com.demo.no00;

import java.util.ArrayList;
import java.util.List;

/**
 * *77 组合
 * 剪枝
 */
public class No77_1 {

    //双端链表，移除最后一个元素o(1)
    public List<Integer> path = new ArrayList<>();
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) {
            return null;
        }
        backTracing(n, k, 1);
        return result;
    }

    public void backTracing(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backTracing(n, k, i + 1);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {

    }
}
