package com.demo.no02;

import javax.management.Query;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 */
public class No225_1 {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public No225_1() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
        //交换
        Queue<Integer> temp = new LinkedList<>();
        temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
