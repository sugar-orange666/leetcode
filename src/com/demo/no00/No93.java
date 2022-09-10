package com.demo.no00;

import java.util.ArrayList;
import java.util.List;

public class No93 {

    public List<String> path = new ArrayList<>();
    public List<List<String>> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        path.clear();
        result.clear();
        backTracing(s, 0);
        List<String> res = new ArrayList<>();

        for (List<String> strings : result) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String ss : strings) {
                stringBuilder.append(ss).append(".");
            }
            //移除最后一个"."
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            res.add(stringBuilder.toString());
        }
        return res;
    }


    public void backTracing(String s, Integer startIndex) {
        if (path.size() == 4) {
            if (startIndex >= s.length()) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            String str = s.substring(startIndex, i + 1);
            if (isValid(str)) {
                path.add(str);
                backTracing(s, i + 1);
                path.remove(path.size() - 1);
            } else {
                break;
            }
        }


    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int temp = Integer.parseInt(s);
        if (s.equals("0")) {
            return true;
        }
        return temp <= 255 && s.charAt(0) != '0';
    }

    public static void main(String[] args) {
        No93 no93 = new No93();
        System.out.println(no93.restoreIpAddresses("25525511135"));
        System.out.println(no93.restoreIpAddresses("0000"));
        System.out.println(no93.restoreIpAddresses("101023"));

    }
}
