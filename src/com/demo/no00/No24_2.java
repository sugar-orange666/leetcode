package com.demo.no00;

import com.common.ListNode;

public class No24_2 {
    public ListNode swapPairs(ListNode head) {
        // base case 退出提交
        if (head == null || head.next == null) return head;
        // 获取当前节点的下一个节点
        ListNode next = head.next;
        // 进行递归
        ListNode newNode = swapPairs(next.next);
        // 这里进行交换
        next.next = head;
        head.next = newNode;

        return next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;
        No24_2 no24_2 = new No24_2();
        no24_2.swapPairs(node1);

        while (node2 != null) {
            System.out.println(node2.val);
            node2 = node2.next;
        }
    }
}
