package com.demo.no04;

import java.util.Arrays;

public class No452_1 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > points[i - 1][1]) {
                count++;
            } else {
                //更新最小右边界
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }

        return count;
    }
}
