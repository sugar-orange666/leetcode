package com.demo.no00;

public class No69_1 {
    public int mySqrt(int x) {
        int left = 1, right = x;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return left - 1;
    }
}
