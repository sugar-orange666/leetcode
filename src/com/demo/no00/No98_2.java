package com.demo.no00;

import com.common.TreeNode;

public class No98_2 {
    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean left = isValidBST(root.left);
        if (pre != null) {
            if (pre.val >= root.val) {
                return false;
            }
        }
        pre=root;
        boolean right = isValidBST(root.right);

        return left && right;
    }
}
