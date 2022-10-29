package com.demo.no03;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 347. 前 K 个高频元素
 */
public class No347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hashMap.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());//Lambda表达式
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();

        }
        return res;
    }

    public static void main(String[] args) {
        No347 no347 = new No347();
        int[] res = no347.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(res));
    }

}
