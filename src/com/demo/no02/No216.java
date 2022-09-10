package com.demo.no02;

import java.util.ArrayList;
import java.util.List;

public class No216 {


    public List<Integer> path = new ArrayList<>();
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracing(k, n, 1, 0);
        return result;
    }


    public void backTracing(int k, int n, int startIndex, int sum) {
        if (sum > n) {
            return;
        }
        if (path.size() == k) {
            if (sum== n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backTracing(k, n, i + 1, sum);
            path.remove(path.size() - 1);
            sum -= i;
        }

    }

//    public int sum(List<Integer> path) {
//        int sum = 0;
//        for (Integer integer : path) {
//            sum += integer;
//        }
//        return sum;
//    }

    public static void main(String[] args) {
        No216 no216 = new No216();
//        System.out.println(no216.combinationSum3(3,9));
        System.out.println(no216.combinationSum3(3, 7));
        System.out.println(no216.combinationSum3(4, 1));
    }
}
