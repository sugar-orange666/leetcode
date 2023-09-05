package com.demo.no26;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Stream;

/**
 * 2605. 从两个数字数组里生成最小数字
 * @Date：2023/9/5 12:48
 * @Description
 */
public class No2605 {
    public int minNumber(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        int min1 = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
            min1 = Math.min(min1, nums1[i]);
        }


        int min2 = Integer.MAX_VALUE;
        int intersectionMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                intersectionMin = Math.min(intersectionMin, nums2[i]);
            }
            min2 = Math.min(min2, nums2[i]);
        }

        //有交集，直接返回
        if (intersectionMin != Integer.MAX_VALUE) {
            return intersectionMin;
        }
        //没有交集 最小的数*10+另一个数组最小的数
        if (min1 < min2) {
            return min1 * 10 + min2;
        }
        return min2 * 10 + min1;

    }


    public static void main(String[] args) {
        No2605 test = new No2605();
        int res = test.minNumber(new int[]{3, 5, 2, 6}, new int[]{3, 1, 7});
        System.out.println(res);
    }
}
