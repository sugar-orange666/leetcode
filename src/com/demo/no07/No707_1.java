package com.demo.no07;

import java.util.List;

/**
 * 单链表-简洁代码
 */
public class No707_1 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }


    public class MyLinkedList {
        /**
         * 虚拟头节点
         */
        public ListNode head;
        public int size;

        public MyLinkedList() {
            head = new ListNode(-1);
            size = 0;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }

            ListNode p = head.next;
            for (int i = 0; p != null && i < index; p = p.next, i++) ;
            return p == null ? -1 : p.val;

        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index < 0) {
                index = 0;
            }
            if (index > size) {
                return;
            }
            ListNode pre = head, p = head.next;
            for (int i = 0; p != null && i < index; i++, pre = pre.next, p = p.next) ;

            ListNode addNode = new ListNode(val);
            pre.next = addNode;
            addNode.next = p;
            size++;

        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            ListNode pre = head, p = head.next;
            for (int i = 0; i < index; i++, pre = pre.next, p = p.next) ;

            pre.next = p.next;
            size--;


        }
    }
}
