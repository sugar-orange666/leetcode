package com.demo.no03;

public class No392_1 {
    public static boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i >= s.length();
    }

    public static void main(String[] args) {
        No392 no392 = new No392();
        System.out.println(no392.isSubsequence("abc","ahbgdc"));
    }
}
