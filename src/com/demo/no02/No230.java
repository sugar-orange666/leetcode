package com.demo.no02;

import com.common.TreeNode;

/**
 * 230. 二叉搜索树中第K小的元素
 *
 * @Date：2024/1/20 16:49
 * @Description
 */
public class No230 {

    int no;
    int res = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        no = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (res != Integer.MIN_VALUE) {
            return;
        }


        dfs(root.left);
        no--;
        if (no == 0) {
            res = root.val;
            return;
        }
        dfs(root.right);
    }

}
