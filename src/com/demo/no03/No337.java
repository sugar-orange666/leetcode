package com.demo.no03;

import com.common.TreeNode;

/**
 * 337.打家劫舍 III
 */
public class No337 {
    public int rob(TreeNode root) {
        int[] res = robAction(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robAction(TreeNode treeNode) {
        int[] res = new int[2];
        if (treeNode == null) {
            return res;
        }

        int[] left = robAction(treeNode.left);
        int[] right = robAction(treeNode.right);
        //偷
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = treeNode.val + left[0] + right[0];
        return res;
    }
}
