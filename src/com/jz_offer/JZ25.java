package com.jz_offer;

import com.common.ListNode;

/**
 * 剑指 Offer II 025. 链表中的两数相加
 */
public class JZ25 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        l1 = reverse(l1);
        l2 = reverse(l2);
//        System.out.printf("l1:");
//        ListNode.print(l1);
//        System.out.printf("l2:");
//        ListNode.print(l2);

        ListNode p1 = l1;
        ListNode res = null;
        ListNode p2 = l2;
        int temp = 0;
        while (p1 != null && p2 != null) {
            int x = p1.val + p2.val + temp;
            temp = x / 10;
            x = x % 10;
            res = addAtHead(x, res);
            p1 = p1.next;
            p2 = p2.next;

        }

        while (p1 != null) {
            int x = p1.val + temp;
            temp = x / 10;
            x = x % 10;
            res = addAtHead(x, res);
            p1 = p1.next;
        }
        while (p2 != null) {

            int x = p2.val + temp;
            temp = x / 10;
            x = x % 10;
            res = addAtHead(x, res);
            p2 = p2.next;
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


    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = dummyNode.next;
            dummyNode.next = cur;
            cur = next;
        }

        return dummyNode.next;

    }


    public static void main(String[] args) {
        JZ25 jz25 = new JZ25();
        ListNode head1 = ListNode.createListByArray(new int[]{7, 2, 4, 3});
        ListNode head2 = ListNode.createListByArray(new int[]{5, 6, 4});
        ListNode node = jz25.addTwoNumbers(head1, head2);
        ListNode.print(node);

    }

}
