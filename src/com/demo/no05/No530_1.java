package com.demo.no05;

import com.common.TreeNode;

/**
 * no530 二叉搜索树的最小绝对值差
 */
public class No530_1 {
    public int min = Integer.MAX_VALUE;
    TreeNode pre;

    public int getMinimumDifference(TreeNode root) {
        order(root);
        return min;
    }

    public void order(TreeNode root) {
        if (root == null) {
            return;
        }
        //左
        order(root.left);
        //中
        if (pre != null) {
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;
        //右
        order(root.right);

    }

}
