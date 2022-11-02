package com.demo.no00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 */
public class No56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> (Integer.compare(a[0], b[0])));
        int curMin = intervals[0][0];
        int curMax = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > curMax) {
                res.add(new int[]{curMin, curMax});
//                if (i == intervals.length - 1) {
//                    break;
//                }
                curMin = intervals[i][0];
                curMax = intervals[i][1];
            } else {
                //相交
                curMin = Math.min(curMin, intervals[i][0]);
                curMax = Math.max(curMax, intervals[i][1]);
            }
        }
        res.add(new int[]{curMin, curMax});

        return res.toArray(new int[0][0]);
    }
}
