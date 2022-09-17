package com.demo.no07;

import com.common.ListNode;

import java.util.List;

/**
 * 双链表
 */
public class No707_2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode pre;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }

    public static class MyLinkedList {

        public ListNode head;
        public ListNode tail;
        public int size;

        public MyLinkedList() {
            size = 0;
            head = new ListNode(-1);
            tail = new ListNode(-1);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }
            //从前面遍历

            if (index < size / 2) {
                ListNode p = head.next;
                for (int i = 0; p != tail && i < index; i++, p = p.next) ;
                return p.val;
            }
            //从后面遍历
            else {
                ListNode p = tail.pre;
                for (int i = size - 1; p != head && i > index; i--, p = p.pre) ;
                return p.val;
            }


        }

        public void addAtHead(int val) {
            ListNode node = new ListNode(val);
            head.next.pre = node;
            node.next = head.next;
            node.pre = head;
            head.next = node;
            size++;
        }

        public void addAtTail(int val) {

            ListNode node = new ListNode(val);
            node.pre = tail.pre;
            node.next = tail;
            tail.pre.next = node;
            tail.pre = node;
            size++;


        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            ListNode p = head.next;
            for (int i = 0; i < index && p != tail; i++, p = p.next) {
            }
            ListNode node = new ListNode(val);

            node.next = p;
            node.pre = p.pre;
            p.pre.next = node;
            p.pre = node;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index >= size || index < 0) {
                return;
            }
            ListNode p = head.next;
            for (int i = 0; i < index && p != tail; i++, p = p.next) {
            }

            p.next.pre = p.pre;
            p.pre.next = p.next;
            size--;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        System.out.println(myLinkedList.get(1));


    }


}
