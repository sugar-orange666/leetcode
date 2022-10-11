package com.demo.no01;

import com.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        Deque<Integer> cur = new LinkedList<>();
        boolean leftOrder = true;
        while (!deque.isEmpty()) {
            cur.clear();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = deque.pop();
                if (leftOrder) {
                    cur.addLast(pop.val);
                } else {
                    cur.addFirst(pop.val);
                }
                if (pop.left != null) {
                    deque.addLast(pop.left);
                }
                if (pop.right != null) {
                    deque.addLast(pop.right);
                }
            }
            result.add(new LinkedList<>(cur));
            leftOrder=!leftOrder;
        }
        return result;
    }
}
