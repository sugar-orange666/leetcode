package com.demo.no02;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 */
public class No225 {

    LinkedList<Integer> queue1;
    LinkedList<Integer> queue2;

    public No225() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        while (!queue1.isEmpty()) {
            queue2.addFirst(queue1.poll());
        }
        return queue2.pollFirst();
    }

    public int top() {
        while (!queue1.isEmpty()) {
            queue2.addFirst(queue1.poll());
        }
        return queue2.peekFirst();
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public static void main(String[] args) {
        No225 no225 = new No225();
        no225.push(1);
        no225.push(2);
        System.out.println(no225.top());
        System.out.println(no225.pop());
        System.out.println(no225.empty());
    }
}
