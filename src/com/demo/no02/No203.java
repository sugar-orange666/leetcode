package com.demo.no02;

import com.common.ListNode;

public class No203 {
    public ListNode removeElements(ListNode head, int val) {

        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode pre = tempHead;
        ListNode p = pre.next;


        while (p != null) {
            if (p.val == val) {
                pre.next = p.next;
                p = pre.next;
            } else {
                p = p.next;
                pre = pre.next;
            }
        }
        return tempHead.next;
    }
}
