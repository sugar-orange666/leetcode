package com.demo.no01;

import com.common.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 */
public class No116 {


    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node pop = deque.pop();
                if (pre != null) {
                    pre.next = pop;
                }
                pre = pop;
                if (pop.left != null) {
                    deque.addLast(pop.left);
                }
                if (pop.right != null) {
                    deque.addLast(pop.right);
                }
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


}
