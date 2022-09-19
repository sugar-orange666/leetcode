package com.demo.no02;

import com.common.ListNode;


//从前向后递归
public class No206_3 {
    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    public ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode temp = cur.next;
        cur.next = pre;
        return reverse(cur, temp);
    }
}
