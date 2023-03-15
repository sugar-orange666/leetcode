package com.jz_offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 剑指 Offer 38. 字符串的排列
 */
public class JZ38 {


    List<String> res = new ArrayList<>();
    boolean[] used = new boolean[]{};

    public String[] permutation(String s) {
        used = new boolean[s.length()];
        Arrays.fill(used, false);
        backTracing(new StringBuilder(), s, 0);
        return res.stream().map(String::valueOf).toArray(String[]::new);
    }


    public void backTracing(StringBuilder cur, String s, int startIndex) {
        System.out.println(cur.toString());
        if (cur.length() >= s.length()) {
            res.add(cur.toString());
            return;
        }

        HashSet<Character> set = new HashSet<>();
        for (int i = startIndex; i < s.length(); i++) {

            //同列用过的直接跳过
            if (used[i]) {
                continue;
            }
            //同层用过的跳过
            if (set.contains(s.charAt(i)) && !used[i]) {
                continue;
            }

            cur.append(s.charAt(i));
            set.add(s.charAt(i));
            used[i] = true;
            backTracing(cur, s, 0);
            cur.deleteCharAt(cur.length() - 1);
            used[i] = false;
        }
    }


    public static void main(String[] args) {
        JZ38 jz38 = new JZ38();
        String[] res = jz38.permutation("aabc");
        System.out.println(Arrays.toString(res));
    }
}
