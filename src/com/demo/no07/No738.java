package com.demo.no07;

import java.util.Arrays;

/**
 * 738. 单调递增的数字
 */
public class No738 {
    public int monotoneIncreasingDigits(int n) {
        //从后往前遍历
        String s = String.valueOf(n);
        String[] ss = s.split("");
        int start = ss.length;
        for (int i = ss.length - 1; i >= 1; i--) {
            if (Integer.parseInt(ss[i - 1]) > Integer.parseInt(ss[i])) {
                ss[i - 1] = (Integer.parseInt(ss[i - 1]) - 1) + "";
                start = i;
            }
        }

        for (int i = start; i < ss.length; i++) {
            ss[i] = "9";
        }

        return Integer.parseInt(String.join("", ss));
    }

    public static void main(String[] args) {
        No738 no738 = new No738();
//        int i = no738.monotoneIncreasingDigits(33332);
        int i = no738.monotoneIncreasingDigits(10);
        System.out.println(i);
    }
}
