package com.demo.no03;

import java.util.Arrays;

/**
 * 343. 整数拆分
 */
public class No343 {
    public int integerBreak(int n) {
        //dp代表当前乘积最大的数字
        int[] dp = new int[n + 1];
        //初始化1的位置
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            //0的位置不用考虑，乘以0=0
            int max = 0;
            for (int j = 1; j < i; j++) {
                //和前面每一个最大的值相乘，算出来本次的最大乘积
                // a,0,b 需要把之前0为那次也算上 比如i=4，2*2 （2,2)
                max = Math.max(Math.max(max, dp[j] * (i - j)), j * (i - j));
            }
            dp[i] = max;
        }

//        System.out.println("dp:" + Arrays.toString(dp));

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        No343 no343 = new No343();
//        System.out.println(no343.integerBreak(2));
        System.out.println(no343.integerBreak(10));
//        System.out.println(no343.integerBreak(4));
    }
}
