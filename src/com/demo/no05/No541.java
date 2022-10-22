package com.demo.no05;

/**
 * 541. 反转字符串 II
 */
public class No541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            reverser(chars, i, Math.min(i + k, s.length()) - 1);
        }
        return new String(chars);
    }


    public void reverser(char[] chars, int start, int end) {
        for (int i = start, j = end; i < chars.length && j >= 0 && i < j; i++, j--) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

    }


    public static void main(String[] args) {
        No541 no541 = new No541();
//        String s = no541.reverseStr("abcd", 2);
        String s = no541.reverseStr("abcd", 3);
//        String s = no541.reverseStr("abcdefg", 2);
        System.out.println(s);
    }


}
