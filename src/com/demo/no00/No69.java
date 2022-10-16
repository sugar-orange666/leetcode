package com.demo.no00;

/**
 * 69. x 的平方根
 */
public class No69 {
    public int mySqrt(int x) {
        int low = 0, high = x;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if ((long) mid * mid == x) {
                return mid;
            } else if ((long) mid * mid < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (long)mid * mid > x ? mid - 1 : mid;
    }

    public static void main(String[] args) {
        No69 no69 = new No69();
//        System.out.println(no69.mySqrt(4));
//        System.out.println(no69.mySqrt(8));
        System.out.println(no69.mySqrt(2147395599));
    }
}
