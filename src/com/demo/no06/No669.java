package com.demo.no06;

import com.common.TreeNode;
import com.common.TreeNodeCommonMethod;

import java.util.List;

/**
 * 669. 修剪二叉搜索树
 */
public class No669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
//        System.out.println("遍历:" + root.val);
        if (root.val < low || root.val > high) {
//            System.out.println("删除:" + root.val);
            root = deleteNode(root);
            return trimBST(root, low, high);
        }

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }


    public TreeNode deleteNode(TreeNode root) {

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

    public static void main(String[] args) {
        int[] inorder = new int[]{3, 1, 2, 4};
        int[] postorder = new int[]{2, 1, 4, 3};
        TreeNode treeNode = TreeNodeCommonMethod.buildTree(inorder, postorder);
        No669 no669 = new No669();
        TreeNode result = no669.trimBST(treeNode, 1, 2);
        List<List<Integer>> list = TreeNodeCommonMethod.levelOrder(result);
        System.out.println(list);

    }


}
