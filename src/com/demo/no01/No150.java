package com.demo.no01;

import com.demo.no00.No15;

import java.util.HashSet;
import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 */
public class No150 {
    public int evalRPN(String[] tokens) {
        Integer res = 0;
        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String cur = tokens[i];
            if (set.contains(cur)) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();

                switch (cur) {
                    case "+":
                        stack.push(num2 + num1);
                        break;
                    case "-":
                        stack.push(num2 - num1);
                        break;
                    case "*":
                        stack.push(num2 * num1);
                        break;
                    case "/":
                        stack.push(num2 / num1);
                        break;
                    default:
                        break;
                }

            } else {
                stack.push(Integer.parseInt(cur));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        No150 no150 = new No150();
//        System.out.println(no150.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(no150.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(no150.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));

    }
}
