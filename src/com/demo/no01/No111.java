package com.demo.no01;

import com.common.TreeNode;

public class No111 {


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int minLeft = minDepth(root.left);
        int minRight = minDepth(root.right);
        if (root.left == null && root.right != null) {
            return 1 + minRight;
        }
        if (root.right == null && root.left != null) {
            return 1 + minLeft;
        }
        return Math.min(1 + minLeft, 1 + minRight);
    }


}
