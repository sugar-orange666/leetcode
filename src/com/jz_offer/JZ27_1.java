package com.jz_offer;

import com.common.ListNode;

import java.util.List;

/**
 * 剑指 Offer II 027. 回文链表
 */
public class JZ27_1 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode slow = dummyNode;
        ListNode fast = dummyNode;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;
        secondHead = reverseListNode(secondHead);


        return isSameListNode(head, secondHead);
    }


    public ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public boolean isSameListNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head2 == null && head1 == null;
        }


        ListNode p1 = head1;
        ListNode p2 = head2;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        //在本题的场景下，head1要么和head2长度相等，要么多一个值，多的那个值不用做比较

        return true;
//        return p1 == null && p2 == null;
    }


    public static void main(String[] args) {
        JZ27_1 jz27_1 = new JZ27_1();
        boolean palindrome = jz27_1.isPalindrome(ListNode.createListByArray(new int[]{1, 2, 3, 2, 1}));
//        boolean palindrome = jz27_1.isPalindrome(ListNode.createListByArray(new int[]{1, 2, 3, 3, 2, 1}));
        System.out.println(palindrome);
    }

}
