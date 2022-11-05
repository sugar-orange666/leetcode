package com.demo.no00;

/**
 * 70. 爬楼梯
 */
public class No70 {
    //    public int climbStairs(int n) {
//        int[] dp = new int[n + 1];
//        if (n <= 2) {
//            return n;
//        }
//        dp[0] = 0;
//        dp[1] = 1;
//        dp[2] = 2;
//        for (int i = 3; i <= n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[n];
//    }
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int a = 1, b = 2, cur=0;
        for (int i = 3; i <= n; i++) {
            cur = a + b;
            a = b;
            b = cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        No70 no70 = new No70();
        System.out.println(no70.climbStairs(1));
        System.out.println(no70.climbStairs(3));
    }
}
