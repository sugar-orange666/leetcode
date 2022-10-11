package com.demo.no04;

import com.common.TreeNode;

public class No450_1 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.right == null) {
                return root.left;
            } else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                sawp(cur, root);
            }
        }
        root.left = deleteNode(root.left, key);
        root.right = deleteNode(root.right, key);
        return root;
    }

    public void sawp(TreeNode node1, TreeNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;

    }

}
