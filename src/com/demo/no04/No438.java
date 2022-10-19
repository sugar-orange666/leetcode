package com.demo.no04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * 438. 找到字符串中所有字母异位词
 */
public class No438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return list;
        }
        if (s.length() < p.length()) {
            return list;
        }
        HashMap<Character, Integer> pMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
        }


        int start = 0;
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (int end = 0; end < s.length(); ) {
            while ((end - start + 1) <= p.length()) {
                sMap.put(s.charAt(end), sMap.getOrDefault(s.charAt(end), 0) + 1);
                end++;
            }
            if (isSameHashMap(sMap, pMap)) {
                list.add(start);
            }
            sMap.put(s.charAt(start), sMap.get(s.charAt(start)) - 1);
            if (sMap.get(s.charAt(start)) == 0) {
                sMap.remove(s.charAt(start));
            }
            start++;

        }
        return list;
    }

    public boolean isSameHashMap(HashMap<Character, Integer> a, HashMap<Character, Integer> b) {
        if (a.size() != b.size()) {
            return false;
        }
        for (Character character : a.keySet()) {
            if (!b.containsKey(character) || !Objects.equals(b.get(character), a.get(character))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No438 no438 = new No438();
//        HashMap<Character, Integer> a = new HashMap<>();
//        a.put('a', 2);
//        HashMap<Character, Integer> b = new HashMap<>();
//        b.put('a', 2);
//        System.out.println(no438.isSameHashMap(a, b));
//        List<Integer> anagrams = no438.findAnagrams("cbaebabacd", "abc");
        List<Integer> anagrams = no438.findAnagrams("abab", "ab");
        System.out.println(anagrams);

    }
}
