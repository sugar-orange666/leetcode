package com.demo.no04;

import java.util.ArrayList;
import java.util.List;

public class No438_1 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()) {
            return res;
        }
        int[] sArray = new int[26];
        int[] pArray = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pArray[p.charAt(i) - 'a']++;
        }
        int start = 0;
        for (int end = 0; end < s.length(); ) {
            while (end - start < p.length()) {
                sArray[s.charAt(end) - 'a']++;
                end++;
            }
            if (isSame(sArray, pArray)) {
                res.add(start);
//                sArray[s.charAt(start) - 'a']--;
//                continue;
            }
            sArray[s.charAt(start) - 'a']--;
            start++;
        }

        return res;
    }


    public boolean isSame(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No438_1 no438_1 = new No438_1();
//        int[] a = new int[26];
//        int[] b = new int[26];
//
//        a['b' - 'a'] = 1;
//        a['c' - 'a'] = 1;
//        b['b' - 'a'] = 1;
//        b['c' - 'a'] = 1;
//
//        System.out.println(no438_1.isSame(a, b));
//        List<Integer> anagrams = no438_1.findAnagrams("cbaebabacd", "abc");
        List<Integer> anagrams = no438_1.findAnagrams("abab", "ab");
        System.out.println(anagrams);


    }

}
