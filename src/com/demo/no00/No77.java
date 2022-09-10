package com.demo.no00;

import java.util.ArrayList;
import java.util.List;
//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
public class No77 {

    //不要用static，static在提交的时候，第二个测试用例和前一个测试用例是共享该字段的
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

        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backTracing(n, k, i + 1);
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {

    }
}
