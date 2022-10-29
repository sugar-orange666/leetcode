package com.demo.no00;

import java.util.HashMap;
import java.util.Stack;

/**
 * 20. 有效的括号
 */
public class No20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('(', ')');
        hashMap.put('[', ']');
        hashMap.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }

            char cur = s.charAt(i);
            if (cur == '(' || cur == '{' || cur == '[') {
                stack.push(cur);
            } else {
                Character peek = stack.peek();
                if (hashMap.get(peek) != null && hashMap.get(peek) == cur) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        No20 no20 = new No20();
        System.out.println(no20.isValid("()"));
//        System.out.println(no20.isValid("()[]{}"));
//        System.out.println(no20.isValid("(])"));
    }
}
