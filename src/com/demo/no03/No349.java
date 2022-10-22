package com.demo.no03;

import java.util.HashSet;

public class No349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            hashSet.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (hashSet.contains(nums2[i])) {
                res.add(nums2[i]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
