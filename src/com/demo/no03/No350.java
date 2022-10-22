package com.demo.no03;

import com.demo.no00.No35;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * no350 两个数组的交接II
 */
public class No350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }


        for (int i = 0; i < nums2.length; i++) {
            if (map.get(nums2[i]) != null) {
                res.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
                if (map.get(nums2[i]) == 0) {
                    map.remove(nums2[i]);
                }
            }

        }
        if (res.size() == 0) {
            return new int[0];
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        No350 no350 = new No350();
        int[] intersect = no350.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        System.out.println(Arrays.toString(intersect));
    }
}
