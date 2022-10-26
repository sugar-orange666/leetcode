package com.demo.no00;

import java.util.Arrays;

/**
 * 28. 找出字符串中第一个匹配项的下标
 */
public class No28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null
                || haystack.length() == 0 || needle.length() == 0
                || needle.length() > haystack.length()) {
            return -1;
        }
        int j = 0;
        int[] next = getNext(needle);
        for (int i = 0; i < haystack.length(); i++) {
            while (j >= 1 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }

            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            //因为上面加1了，所以这里是==
            if (j == needle.length() ) {
                return i - needle.length() + 1;
            }
            //不相等的情况


        }
        return -1;
    }

    public int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        int i = 1;
        int j = 0;
        next[0] = 0;
        for (; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                next[i] = ++j;
            } else {
                next[i] = j;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        No28 no28 = new No28();
//        int i = no28.strStr("abcxabcdabxabcdabcdabcy", "abcdabcy");
//        int i = no28.strStr("sadbutsad", "sad");
//        System.out.println(i);
        int[] next = no28.getNext("abaababaab");
        System.out.println(Arrays.toString(next));
    }
}
