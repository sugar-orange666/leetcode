package com.demo.no00;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 */
public class No22 {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backTracing(new StringBuilder(), n);
        return res;
    }

    public void backTracing(StringBuilder cur, int n) {
        System.out.println("cur:" + cur);
        if (cur.length() == n * 2) {
            if (isValid(cur)) {
                res.add(cur.toString());
            }
            return;
        }

        cur.append("(");
        backTracing(cur, n);
        cur.deleteCharAt(cur.length() - 1);

        cur.append(")");
        backTracing(cur, n);
        cur.deleteCharAt(cur.length() - 1);

    }


    public boolean isValid(StringBuilder s) {
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                if (left < 1) {
                    return false;
                }
                left--;
            }
        }

        return left == 0;
    }
}
