package com.demo.no02;

import com.common.TreeNode;

public class No222_3 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = 0;
        int rightDepth = 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (left != null) {
            left = left.left;
            leftDepth++;
        }
        while (right != null) {
            right = right.right;
            rightDepth++;
        }

        if (rightDepth == leftDepth) {
            return (2 << leftDepth) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;

    }


}
