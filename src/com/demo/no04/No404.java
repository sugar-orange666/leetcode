package com.demo.no04;

import com.common.TreeNode;

public class No404 {
    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        order(root, null);
        return sum;
    }

    public void order(TreeNode root, TreeNode prev) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && prev != null && prev.left == root) {
            sum += root.val;
            return;
        }
        //遍历次序 左根右 中序遍历

        order(root.left, root);

        order(root.right, root.left);
    }
}
