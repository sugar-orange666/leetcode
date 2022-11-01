package com.demo.no04;

import java.util.Arrays;

/**
 * 452. 用最少数量的箭引爆气球
 */
public class No452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            //按照第一行升序
            return a[0] - b[0];
        });

        int curMin = Integer.MAX_VALUE;
        int curMax = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            int xStart = points[i][0];
            int xEnd = points[i][1];
            //有交集
            if ((curMin <= xStart && xStart <= curMax) || (curMin <= xEnd && xEnd <= curMax)) {
                curMin = Math.max(curMin, xStart);
                curMax = Math.min(curMax, xEnd);
            } else {
                count++;
                curMin = xStart;
                curMax = xEnd;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        No452 no452 = new No452();
        System.out.println(no452.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}, {7, 11}}));
        System.out.println(no452.findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
        System.out.println(no452.findMinArrowShots(new int[][]{{1,2},{2,3},{3,4},{4,5}}));

    }
}
