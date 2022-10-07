package com.demo.no01;

import com.common.TreeNode;

public class No111_2 {
    private int result;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        result = -1;
        getDepth(root, 1);
        return result;
    }

    public void getDepth(TreeNode root, int curDepth) {
        if (root.left == null && root.right == null) {
            result = Math.min(result, curDepth);
            return;
        }
        //根 此处没有处理逻辑
        //左
        if (root.left != null) {
            getDepth(root.left, curDepth + 1);
        }
        //右
        if (root.right != null) {
            getDepth(root.right, curDepth + 1);
        }
        return;
    }
}
