package com.demo.no02;

import com.common.TreeNode;

public class No222 {
    private int count;

    public int countNodes(TreeNode root) {
        preOrder(root);
        return count;
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        count++;
        preOrder(root.left);
        preOrder(root.right);
    }
}
