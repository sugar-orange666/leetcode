package com.demo.no02;

import com.common.ListNode;

/**
 * 从后向前递归
 */
public class No206_2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
