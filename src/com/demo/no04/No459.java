package com.demo.no04;

import java.util.Arrays;

/**
 * 459. 重复的子字符串
 */
public class No459 {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() <= 0) {
            return false;
        }
        int[] nextValue = getNextValue(s);
        System.out.println("nextValue:" + Arrays.toString(nextValue));
        //如果最后一位是0，说明最后一位无匹配的前后缀，直接返回
        if (nextValue[nextValue.length - 1] == 0) {
            return false;
        }
        //数组长度余 最长相等前后缀的剩余长度是否为0
        return s.length() % (s.length() - nextValue[nextValue.length - 1]) == 0;
    }

    public int[] getNextValue(String s) {
        int[] next = new int[s.length()];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j != 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        return next;
    }

    public static void main(String[] args) {
        No459 no459 = new No459();
//        int[] value = no459.getNextValue("abcabcabc");
//        int[] value = no459.getNextValue("aba");
//        int[] value = no459.getNextValue("aabaabaaa");
//        System.out.println(Arrays.toString(value));
//        boolean pattern = no459.repeatedSubstringPattern("abab");
//        boolean pattern = no459.repeatedSubstringPattern("aba");
//        boolean pattern = no459.repeatedSubstringPattern("abab");
//        boolean pattern = no459.repeatedSubstringPattern("aaaa");
//        boolean pattern = no459.repeatedSubstringPattern("a");
        boolean pattern = no459.repeatedSubstringPattern("abac");
        System.out.println(pattern);
    }
}
