package com.common;


public class ListNode {

    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public static void addAtTail(ListNode head, int val) {
        if (head == null) {
            head = new ListNode(val);
        }
        ListNode p = head;

        for (; p.next != null; p = p.next) {
        }
        p.next = new ListNode(val);
    }

    public static void print(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.printf(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }


    /**
     * 通过数组创建链表，返回链表头节点，链表不包含虚拟头节点
     *
     * @param nums nums
     * @return ListNode
     */
    public static ListNode createListByArray(int[] nums) {
        if (nums == null) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode pre = head;
        for (int j = 1; j < nums.length; j++) {
            pre.next = new ListNode(nums[j]);
            pre = pre.next;
        }
        return head;
    }
}
