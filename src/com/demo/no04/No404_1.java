package com.demo.no04;

import com.common.TreeNode;

public class No404_1 {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        if (left.left == null && left.right == null) {
            sum += left.val;
        }
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;

    }
}
