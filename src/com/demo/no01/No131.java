package com.demo.no01;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class No131 {


    public List<String> path = new ArrayList<>();
    public List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backTracing(s, 0);
        return result;
    }


    public void backTracing(String s, int startIndex) {
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String str = s.substring(startIndex, i + 1);
            if (isPalindrome(str)) {
                path.add(str);
                backTracing(s, i + 1);
            } else {
                continue;
            }
            path.remove(path.size() - 1);
        }
    }

    public boolean isPalindrome(String s) {

        int i = 0, j = s.length() - 1;

        for (; i < s.length() && j >= 0; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        No131 no131 = new No131();
//        System.out.println(no131.isPalindrome("111"));
//        System.out.println(no131.isPalindrome("112"));
//        System.out.println(no131.isPalindrome("121"));
//        System.out.println(no131.partition("aab"));
//        System.out.println(no131.partition("a"));
        System.out.println("123".substring(1,3));
    }

}
