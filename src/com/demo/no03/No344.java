package com.demo.no03;

import com.demo.no00.No34;

import java.util.Arrays;

/**
 * no344 反转字符串
 */
public class No344 {
    public void reverseString(char[] s) {
        for (int p = 0, q = s.length - 1; p < s.length && q > 0 && p < q; p++, q--) {
            char temp = s[p];
            s[p] = s[q];
            s[q] = temp;
        }
//        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        No344 no344 = new No344();
        no344.reverseString(new char[]{'h','e','l','l','o'});
    }
}
