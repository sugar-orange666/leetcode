package com.demo.no04;

import com.common.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 */
public class No450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        //1. 如果没有找到，返回null
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            //2. 如果是叶子节点，直接返回null
            if (root.left == null && root.right == null) {
                return null;
            }
            //3. 如果左子树不为空，右子树为空，返回root.left
            else if (root.left != null && root.right == null) {
                return root.left;
            }
            //4.如果右子树不为空，左子树为空，返回root.right
            else if (root.left == null && root.right != null) {
                return root.right;
            }
            //5.左右都不为空
            else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                return root.right;
            }
        }
        //查找节点
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        return root;

    }

}
