package com.demo.no03;

/**
 * 367. 有效的完全平方数
 */
public class No367 {
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            long temp = (long) mid * mid;
            if (temp == num) {
                return true;
            } else if (temp < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        No367 no367 = new No367();
        System.out.println(no367.isPerfectSquare(5));
    }

}
