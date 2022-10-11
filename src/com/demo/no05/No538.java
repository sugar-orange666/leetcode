package com.demo.no05;

import com.common.TreeNode;

/**
 * 538. 把二叉搜索树转换为累加树
 */
public class No538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        //右中左
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
