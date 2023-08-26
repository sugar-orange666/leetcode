package com.demo.no02;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 * @Date：2023/8/26 17:01
 * @Description
 */
public class No228 {

    List<String> res = new ArrayList<>();

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        int curMin = nums[0];
        int curMax = nums[0];


        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == curMax + 1) {
                curMax = nums[i];
            } else {
                if (curMin != curMax) {
                    res.add(curMin + "->" + curMax);
                } else {
                    res.add(String.valueOf(curMin));
                }

                curMin = nums[i];
                curMax = nums[i];
            }


        }
        if (curMin != curMax) {
            res.add(curMin + "->" + curMax);
        } else {
            res.add(String.valueOf(curMin));
        }

        return res;
    }

    public static void main(String[] args) {
        No228 test = new No228();
//        List<String> list = test.summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
        List<String> list = test.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9});
        System.out.println(list);
    }
}
