package com.demo.no01;

import com.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null) {
            return list;
        }
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = deque.pop();
                if (pop.left != null) {
                    deque.addLast(pop.left);
                }
                if (pop.right != null) {
                    deque.addLast(pop.right);
                }
                if (i == size - 1) {
                    list.add(pop.val);
                }
            }
        }
        return list;
    }
}
