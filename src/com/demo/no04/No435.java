package com.demo.no04;

import java.util.Arrays;

/**
 * 435. 无重叠区间
 */
public class No435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1) {
            return 0;
        }
        //升序排序
        Arrays.sort(intervals, (a, b) -> {
            //如果是负数,按照降序排序
//            if (a[0] == b[0]) {
//                return a[1] - b[1];
//            }
            return a[0] - b[0];
        });
        int minLeft = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            //相交了
            if (intervals[i][0] < minLeft) {
                //相交的时候取右边的最小值
                minLeft = Math.min(minLeft, intervals[i][1]);
                count++;
            } else {
                //不相交
                minLeft = intervals[i][1];
            }

        }
        return count;
    }
}
