package com.demo.no07;

import com.common.TreeNode;

public class No700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        while (root != null) {
            if (root.val == val) {
                return root;
            }

            if (val > root.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return null;
    }
}
