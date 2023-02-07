package com.demo.no01;

import com.common.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 */
public class No124 {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftGain = Math.max(0, maxGain(node.left));
        int rightGain = Math.max(0, maxGain(node.right));
        int newPrice = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, newPrice);
        return Math.max(leftGain, rightGain) + node.val;
    }

}

