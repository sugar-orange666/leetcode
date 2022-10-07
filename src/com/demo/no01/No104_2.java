package com.demo.no01;

import com.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class No104_2 {
    public int maxDepth(TreeNode root) {
        int maxDepth = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        deque.addLast(root);

        while (!deque.isEmpty()) {
            maxDepth++;
            int size = deque.size();

            for (int i = 0; i < size; i++) {
                TreeNode pop = deque.pop();
                if (pop.left != null) {
                    deque.addLast(pop.left);
                }
                if (pop.right != null) {
                    deque.addLast(pop.right);
                }
            }

        }
        return maxDepth;
    }
}
