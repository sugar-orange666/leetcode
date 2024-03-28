package com.demo.no08;

import java.util.Arrays;

/**
 * @Date：2024/3/28 13:48
 * @Description
 */
public class No844_2 {
    public boolean backspaceCompare(String s, String t) {
        s = getString(s.toCharArray());
        t = getString(t.toCharArray());
        // System.out.println(s);
        // System.out.println(t);
        return s.equals(t);
    }


    public String getString(char[] chars) {
        int end = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '#') {
                chars[end++] = chars[i];
            } else {
                end--;
                if (end < 0) {
                    end = 0;
                }
            }
        }
        if (end < 0) {
            return "";
        }
        return String.valueOf(Arrays.copyOfRange(chars, 0, end));
    }
}
