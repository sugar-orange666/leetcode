package com.demo.no04;

import java.util.HashMap;

/**
 * no454. 四数相加 II
 */
public class No454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i], hashMap.getOrDefault(nums1[i], 0) + 1);
        }

        HashMap<Integer, Integer> m1 = dealHashMap(hashMap, nums2);
        HashMap<Integer, Integer> m2 = dealHashMap(m1, nums3);
        HashMap<Integer, Integer> m3 = dealHashMap(m2, nums4);


        return m3.get(0) != null ? m3.get(0) : 0;
    }


    public HashMap<Integer, Integer> dealHashMap(HashMap<Integer, Integer> hashMap, int[] nums) {
        HashMap<Integer, Integer> tempMap = new HashMap<>();
        for (Integer integer : hashMap.keySet()) {
            for (int i = 0; i < nums.length; i++) {
                Integer cur = integer + nums[i];
                Integer value = hashMap.get(integer);
                tempMap.put(cur, tempMap.getOrDefault(cur, 0) + value);
            }
        }
        hashMap = new HashMap<>(tempMap);
        return hashMap;
    }

    public static void main(String[] args) {
        No454 no454 = new No454();
        int sumCount = no454.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2});
        System.out.println(sumCount);
    }
}
