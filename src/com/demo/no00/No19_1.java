package com.demo.no00;

import com.common.ListNode;

public class No19_1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode p = dummyNode, q = dummyNode;
        for (int i=0; i < n && p != null; i++) {
            p = p.next;
        }
        //根据题意，要删除的节点肯定存在
        for (; p.next != null; p = p.next, q = q.next) {
        }
        q.next = q.next.next;
        return dummyNode.next;
    }
}
