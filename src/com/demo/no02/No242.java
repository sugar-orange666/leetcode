package com.demo.no02;

import java.util.HashMap;

/**
 * 242. 有效的字母异位词
 */
public class No242 {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }


        for (int i = 0; i < t.length(); i++) {
            if (hashMap.get(t.charAt(i)) == null) {
                return false;
            } else {
                hashMap.put(t.charAt(i), hashMap.get(t.charAt(i)) - 1);
                if (hashMap.get(t.charAt(i)) == 0) {
                    hashMap.remove(t.charAt(i));
                }
            }
        }
        return hashMap.isEmpty();
    }

    public static void main(String[] args) {
        No242 no242 = new No242();
        System.out.println(no242.isAnagram("anagram", "nagaram"));
        System.out.println(no242.isAnagram("rat", "car"));
    }
}
