package com.demo.no02;

import com.common.TreeNode;

/**
 * 222. 完全二叉树的节点个数
 */
public class No222_2 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return leftCount + rightCount + 1;
    }

}
