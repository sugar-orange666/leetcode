package com.demo.no00;

import com.common.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 */
public class No19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 0) {
            return null;
        }
        ListNode p = head, q = head;
        int i = 0;
        for (; i < n && p != null; i++) {
            p = p.next;
        }
        if (p == null) {
            if (i == n) {
                return head.next;
            }
            return head;
        }

        for (; p != null; p = p.next, q = q.next) {
        }
        q.next = q.next.next;
        return head;
    }
}
