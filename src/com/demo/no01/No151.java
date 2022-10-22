package com.demo.no01;

import com.demo.no00.No15;

/**
 * 151. 反转字符串中的单词
 */
public class No151 {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        int end = s.length() - 1;
        for (int start = s.length() - 1; start >= 0; start--) {
            if (s.charAt(start) == ' ' || start == 0) {
                res = createString(s, start, end, res);
                end = start;
            }
        }
        return res.toString();
    }


    public StringBuilder createString(String s, int start, int end, StringBuilder res) {

        while (start < end && s.charAt(start) == ' ') {
            start++;
        }
        while (end >= start && s.charAt(end) == ' ') {
            end--;
        }

        if (start <= end) {
            if (res.length() != 0) {
                res.append(' ');
            }
            res.append(s, start, end + 1);
        }

        return res;
    }


    public static void main(String[] args) {
        No151 no151 = new No151();
        System.out.println(no151.reverseWords("the sky is blue"));
        System.out.println(no151.reverseWords("  hello world  "));
        System.out.println(no151.reverseWords("a good   example"));
    }
}
