package com.demo.no02;

import com.common.ListNode;

public class No206 {
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head.next;
        ListNode tempHead = new ListNode(head.val);

        for (; p != null; p = p.next) {
            ListNode tempNode = new ListNode(p.val);
            tempNode.next = tempHead;
            tempHead = tempNode;
        }


        return tempHead;
    }
}
