package com.demo.no01;

import com.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class No111_1 {
    public int minDepth(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        deque.addLast(root);
        int minDepth = 0;
        boolean flag = true;
        while (!deque.isEmpty()) {
            minDepth++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = deque.pop();
                if (pop.left == null && pop.right == null) {
                    flag = false;
                    break;
                }
                if (pop.left != null) {
                    deque.addLast(pop.left);
                }
                if (pop.right != null) {
                    deque.addLast(pop.right);
                }
            }
            if (!flag) {
                break;
            }


        }
        return minDepth;
    }
}
