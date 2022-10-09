package com.demo.no07;

import com.common.TreeNode;

import java.util.List;

public class No701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null) {
            pre = cur;
            if (val < cur.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if (val > pre.val) {
            pre.right = new TreeNode(val);
        } else {
            pre.left = new TreeNode(val);
        }
        return root;
    }
}
