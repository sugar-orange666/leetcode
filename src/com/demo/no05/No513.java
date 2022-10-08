package com.demo.no05;

import com.common.TreeNode;
import com.sun.source.tree.Tree;

public class No513 {
    int maxDepth = Integer.MIN_VALUE;
    int bottomLeftValue;

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        order(root, 1);
        return bottomLeftValue;
    }

    public void order(TreeNode root, int curDepth) {
        if (root == null) {
            return;
        }
        //叶子节点
        if (root.left == null && root.right == null) {
            if (curDepth > maxDepth) {
                bottomLeftValue = root.val;
                maxDepth = curDepth;
            }
        }
        order(root.left, curDepth + 1);
        order(root.right, curDepth + 1);

    }

}
