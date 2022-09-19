package com.demo.no01;

import com.common.ListNode;

/**
 * 相交链表
 */
public class No160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int num1 = 0, num2 = 0;
        for (ListNode p = headA; p != null; p = p.next, num1++) ;
        for (ListNode q = headB; q != null; q = q.next, num2++) ;

        if (num1 == 0 || num2 == 0) {
            return null;
        }
        ListNode p=headA,q=headB;
        if (num1 < num2) {
           p=headB;
           q=headA;
        }

        int i = 0;
        for (; p != null && i < Math.abs(num1 - num2); p = p.next,i++) ;


        for ( ; q != null && p != null && p!= q; p = p.next, q = q.next) ;

        return p;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(8);
        ListNode node7 = new ListNode(4);
        ListNode node8 = new ListNode(5);


        node1.next = node2;
        node2.next = node6;
        node6.next = node7;
        node7.next = node8;

        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node8;

        No160 no160=new No160();
        System.out.println(no160.getIntersectionNode(node1,node3).val);
    }
}
