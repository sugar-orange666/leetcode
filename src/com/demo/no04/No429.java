package com.demo.no04;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node pop = deque.pop();
                cur.add(pop.val);
                if (pop.children == null || pop.children.size() == 0) {
                    continue;
                }
                for (Node child : pop.children) {
                    if (child != null) {
                        deque.addLast(child);
                    }
                }
            }
            res.add(cur);
        }


        return res;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


}
