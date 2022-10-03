package com.demo.no01;

import com.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No144_3 {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root=root.left;
            }
            TreeNode node = stack.pop();
            root=node.right;
        }
        return list;
    }
}
