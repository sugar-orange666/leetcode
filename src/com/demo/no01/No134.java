package com.demo.no01;

/**
 * 134. 加油站
 */
public class No134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            min = Math.min(sum, min);
        }

        if (sum < 0) {
            return -1;
        }
        if (min >= 0) {
            return 0;
        }
        for (int i = gas.length - 1; i >= 0; i--) {
            min += gas[i] - cost[i];
            if (min >= 0) {
                return i;
            }
        }
        return -1;
    }

    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int curSum = 0;
        int index = 0;
        int totalSum = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                index = i + 1;
                curSum = 0;
            }
        }
        return totalSum >= 0 ? index : -1;

    }


}
