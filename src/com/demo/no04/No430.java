package com.demo.no04;

import java.util.ArrayList;
import java.util.List;

/**
 * 430. 扁平化多级双向链表
 */
public class No430 {
    public Node flatten(Node head) {

        if (head == null) {
            return null;
        }
        return rollOut(head);
    }


    public Node rollOut(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Node tail = null;

        while (cur != null) {
            Node next = cur.next;
            if (cur.child != null) {
                Node last = rollOut(cur.child);
                cur.next = cur.child;
                cur.child.prev = cur;

                if (next != null) {
                    last.next = next;
                    next.prev = last;
                }
                tail = last;
                cur.child = null;
            } else {
                tail = cur;
            }
            cur = next;


        }

        return tail;

    }

    // Definition for a Node.
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }


}
