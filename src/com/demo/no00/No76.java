package com.demo.no00;

import java.util.HashMap;

public class No76 {
    HashMap<Character, Integer> tMap = new HashMap<>();
    HashMap<Character, Integer> curHashMap = new HashMap<>();

    public String minWindow(String s, String t) {
        String resString = "";
        Integer initLen = Integer.MAX_VALUE;

        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (tMap.get(s.charAt(j)) != null) {
                curHashMap.put(s.charAt(j), curHashMap.getOrDefault(s.charAt(j), 0) + 1);
            }
            while (curHashMap.size() == tMap.size() && check()) {
                if (j - i + 1 < initLen) {
                    resString = s.substring(i, j + 1);
                    initLen = resString.length();
                }
                if (curHashMap.get(s.charAt(i)) != null) {
                    curHashMap.put(s.charAt(i), curHashMap.get(s.charAt(i)) - 1);
                    if (curHashMap.get(s.charAt(i)) == 0) {
                        curHashMap.remove(s.charAt(i));
                    }
                }
                i++;
            }
        }
        return resString;
    }


    public boolean check() {
        for (Character character : curHashMap.keySet()) {
            if (tMap.get(character) == null || curHashMap.get(character) < tMap.get(character)) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        No76 no76 = new No76();
//        String s = no76.minWindow("ADOBECODEBANC", "ABC");
//        String s = no76.minWindow("a", "a");
        String s = no76.minWindow("aa", "aa");
//        String s = no76.minWindow("a", "aa");
        System.out.println("s:" + s);
    }

}
