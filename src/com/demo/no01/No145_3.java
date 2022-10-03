package com.demo.no01;

import com.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No145_3 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        //左右根
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            if (pop.right == null || pop.right == prev) {
                list.add(pop.val);
                prev = pop;
            } else {
                stack.push(pop);
                root = pop.right;
            }


        }


        return list;

    }
}
