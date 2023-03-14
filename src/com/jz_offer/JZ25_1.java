package com.jz_offer;

import com.common.ListNode;

import java.util.Stack;

public class JZ25_1 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> stack1 = transferStack(l1);
        Stack<Integer> stack2 = transferStack(l2);

        if (stack2.size() > stack1.size()) {
            Stack<Integer> temp = stack1;
            stack1 = stack2;
            stack2 = temp;
        }

        ListNode res = null;
        int temp = 0;
        while (!stack2.isEmpty()) {
            int x = stack2.pop() + stack1.pop() + temp;
            temp = x / 10;
            x = x % 10;
            res = addAtHead(x, res);
        }


        while (!stack1.isEmpty()) {
            int x = stack1.pop() + temp;
            temp = x / 10;
            x = x % 10;
            res = addAtHead(x, res);
        }


        if (temp != 0) {
            res = addAtHead(temp, res);
        }


        return res;
    }


    public ListNode addAtHead(int x, ListNode head) {
        ListNode cur = new ListNode(x);
        cur.next = head;
        head = cur;
        return head;
    }


    public Stack<Integer> transferStack(ListNode head) {
        if (head == null) {
            return new Stack<>();
        }
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }

        return stack;

    }


    public static void main(String[] args) {
        ListNode head1 = ListNode.createListByArray(new int[]{7, 2, 4, 3});
        ListNode head2 = ListNode.createListByArray(new int[]{5, 6, 4});
        JZ25_1 jz25_1=new JZ25_1();
        ListNode node = jz25_1.addTwoNumbers(head1, head2);
        ListNode.print(node);
    }


}

