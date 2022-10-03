package com.demo.no00;

import com.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No94_2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode pop = stack.pop();
            list.add(pop.val);
            root=pop.right;
        }

        return list;
    }
}
