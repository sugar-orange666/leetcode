package com.demo.no09;

import com.demo.no00.No90;

import java.util.HashMap;

/**
 * 904. 水果成篮
 */
public class No904 {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int res = Integer.MIN_VALUE;
        int i = 0;
        for (int j = 0; j < fruits.length; j++) {
            hashMap.put(fruits[j], hashMap.getOrDefault(fruits[j], 0) + 1);
            while (hashMap.size() > 2) {
                hashMap.put(fruits[i], hashMap.get(fruits[i]) - 1);
                if (hashMap.get(fruits[i]) == 0) {
                    hashMap.remove(fruits[i]);
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;

    }

    public static void main(String[] args) {
        No904 no904 = new No904();
        System.out.println(no904.totalFruit(new int[]{1, 2, 1}));
        System.out.println(no904.totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println(no904.totalFruit(new int[]{1, 2, 3, 2, 2}));
        System.out.println(no904.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
        System.out.println(no904.totalFruit(new int[]{0}));
    }
}
