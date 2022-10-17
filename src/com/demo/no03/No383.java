package com.demo.no03;

import java.util.HashMap;

/**
 * 383. 赎金信
 */
public class No383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            hashMap.put(magazine.charAt(i), hashMap.getOrDefault(magazine.charAt(i), 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (hashMap.get(ransomNote.charAt(i)) == null) {
                return false;
            }
            hashMap.put(ransomNote.charAt(i), hashMap.get(ransomNote.charAt(i)) - 1);
            if (hashMap.get(ransomNote.charAt(i)) == 0) {
                hashMap.remove(ransomNote.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No383 no383 = new No383();
        System.out.println(no383.canConstruct("a", "b"));
        System.out.println(no383.canConstruct("aa", "ab"));
        System.out.println(no383.canConstruct("aa", "aab"));

    }
}
