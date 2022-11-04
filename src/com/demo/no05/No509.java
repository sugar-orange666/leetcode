package com.demo.no05;

/**
 * 509. 斐波那契数
 */
public class No509 {
    public int fib(int n) {


        if (n <= 1) {
            return n;
        }
        int f0 = 0;
        int f1 = 1;
        for (int i = 2; i <= n; i++) {
            int cur = f0 + f1;
            f0 = f1;
            f1 = cur;
        }
        return f1;
    }

    public static void main(String[] args) {
        No509 no509 = new No509();
        System.out.println(no509.fib(2));
        System.out.println(no509.fib(3));
        System.out.println(no509.fib(4));
    }
}
