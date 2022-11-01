package com.demo.no00;

/**
 * 45. 跳跃游戏 II
 */
public class No45 {
    public int jump(int[] nums) {
        int result = 0;
        // 当前覆盖的最远距离下标
        int end = 0;
        // 下一步覆盖的最远距离下标
        int temp = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            temp = Math.max(temp, i + nums[i]);
            // 可达位置的改变次数就是跳跃次数
            if (i == end) {
                end = temp;
                result++;
            }
        }
        return result;
    }
}
