package com.demo.no00;

import com.common.TreeNode;

/**
 * no98. 验证二叉搜索树
 */
public class No98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }

        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
