package com.demo.no01;

import com.common.TreeNode;

public class No104_1 {
    int maxDepth;

    public int maxDepth(TreeNode root) {
        maxDepth = 0;
        if (root == null) {
            return maxDepth;
        }
        getDepth(root, 1);
        return maxDepth;
    }

    public void getDepth(TreeNode root, int curDepth) {
        maxDepth = Math.max(maxDepth, curDepth);
        if (root.left == null && root.right == null) {
            return;
        }

        if (root.left != null) {
            curDepth++;
            getDepth(root.left, curDepth);
            curDepth--;
        }

        if (root.right != null) {
            curDepth++;
            getDepth(root.right, curDepth);
            curDepth--;
        }
        return;
    }


}
