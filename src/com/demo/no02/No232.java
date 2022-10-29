package com.demo.no02;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 */
public class No232 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public No232() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);

    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();

    }

    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();

    }

    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }

    public static void main(String[] args) {
        No232 no232 = new No232();
        no232.push(1);
        no232.push(2);
        System.out.println(no232.peek());
        System.out.println(no232.pop());
        System.out.println(no232.empty());
    }
}
