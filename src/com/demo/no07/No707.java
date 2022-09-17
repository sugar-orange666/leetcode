package com.demo.no07;

import java.util.List;

public class No707 {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static class MyLinkedList {
        public ListNode head;

        public MyLinkedList() {

        }

        public int get(int index) {
            if (index < 0 || head == null) {
                return -1;
            }
            ListNode p = head;
            while (p.next != null && index > 0) {
                p = p.next;
                index--;
            }
            return index == 0 ? p.val : -1;
        }

        public void addAtHead(int val) {
            if (head == null) {
                head = new ListNode(val);
            } else {
                ListNode temp = new ListNode(val);
                temp.next = head;
                head = temp;
            }

        }

        public void addAtTail(int val) {
            if (head == null) {
                head = new ListNode(val);
            } else {
                ListNode p = head;
                for (; p.next != null; p = p.next) ;
                p.next = new ListNode(val);
            }

        }

        public void addAtIndex(int index, int val) {
            if (index < 0) {
                return;
            }

            ListNode tempHead = new ListNode(-1);
            tempHead.next = head;
            ListNode pre = tempHead;
            ListNode p = pre.next;

            while (p != null && index != 0) {
                pre = pre.next;
                p = p.next;
                index--;
            }

            if (index == 0) {
                ListNode addNode = new ListNode(val);
                pre.next = addNode;
                addNode.next = p;
            }
            head = tempHead.next;

        }

        public void deleteAtIndex(int index) {

            if (index < 0 || head == null) {
                return;
            }
            ListNode tempHead = new ListNode(-1);
            tempHead.next = head;
            ListNode pre = tempHead;
            ListNode p = pre.next;

            while (p.next != null && index > 0) {
                pre = pre.next;
                p = p.next;
                index--;
            }

            if (index == 0) {
                if (p.next == null) {
                    //删除头节点
                    pre.next=null;
                }
                if (p.next != null) {
                    pre.next = p.next;
                }
            }

            head=tempHead.next;
        }
    }


    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(4);
//        myLinkedList.addAtHead(5);
//        myLinkedList.addAtTail(6);

//        myLinkedList.addAtIndex(2, 3);
        myLinkedList.deleteAtIndex(0);
        int a = myLinkedList.get(0);
//        int b = myLinkedList.get(2);
//        int c = myLinkedList.get(3);
        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);

    }

}
