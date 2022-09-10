package com.demo.no00;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No17 {


    private StringBuilder stringBuilder=new StringBuilder();
    private List<String> result=new ArrayList<>();

    HashMap<Integer, String> hashMap = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits==null||digits.length()==0)
        {
            return null;
        }

        hashMap.put(2, "abc");
        hashMap.put(3, "def");
        hashMap.put(4, "ghi");
        hashMap.put(5, "jkl");
        hashMap.put(6, "mno");
        hashMap.put(7, "pqrs");
        hashMap.put(8, "tuv");
        hashMap.put(9, "wxyz");
        backTracing(digits,0);
        return result;
    }

    public void backTracing(String digits, int index) {
        if (index == digits.length()) {
            result.add(stringBuilder.toString());
            return;
        }
        int i = digits.charAt(index)-'0';
        String str = hashMap.get(i);
        for (int j = 0; j < str.length(); j++) {
            stringBuilder.append(str.charAt(j));
            backTracing(digits, index + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    public static void main(String[] args) {
        No17 no17=new No17();
        System.out.println(no17.letterCombinations("23"));
    }
}
