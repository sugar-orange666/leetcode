package com.demo.no01;

import com.common.TreeNode;
import com.common.TreeNodeCommonMethod;

import java.util.Arrays;
import java.util.List;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 */
public class No105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);

        int index = 0;
        for (; index < inorder.length; index++) {
            if (inorder[index] == rootValue) {
                break;
            }
        }

//        System.out.println("index:" + index);
        int[] inorder1 = Arrays.copyOfRange(inorder, 0, index);
        int[] inorder2 = Arrays.copyOfRange(inorder, index + 1, inorder.length);
//        System.out.println("inorder1:" + Arrays.toString(inorder1));
//        System.out.println("inorder2:" + Arrays.toString(inorder2));
        int[] preorder1 = Arrays.copyOfRange(preorder, 1, 1 + inorder1.length);
        int[] preOrder2 = Arrays.copyOfRange(preorder, 1 + inorder1.length, preorder.length);

//        System.out.println("preorder1:" + Arrays.toString(preorder1));
//        System.out.println("preorder2:" + Arrays.toString(preOrder2));
        root.left = buildTree(preorder1, inorder1);
        root.right = buildTree(preOrder2, inorder2);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        No105 no105 = new No105();
        TreeNode treeNode = no105.buildTree(preorder, inorder);
        List<List<Integer>> list = TreeNodeCommonMethod.levelOrder(treeNode);
        System.out.println(list);
    }
}
