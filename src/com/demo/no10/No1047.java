package com.demo.no10;

import com.demo.no01.No104;

import java.util.Stack;

/**
 * 1047. 删除字符串中的所有相邻重复项
 */
public class No1047 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(cur);
                continue;
            }
            if (cur == stack.peek()) {
                while (!stack.isEmpty() && stack.peek() == cur) {
                    stack.pop();
                }
            } else {
                stack.push(cur);
            }

        }
        StringBuilder res = new StringBuilder(new String());
        for (Character character : stack) {
            res.append(character);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        No1047 no1047 = new No1047();
        System.out.println(no1047.removeDuplicates("abbaca"));
    }
}
