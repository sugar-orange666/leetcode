package com.demo.no01;

import com.common.TreeNode;
import com.common.TreeNodeCommonMethod;

import java.util.Arrays;
import java.util.List;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class No106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        if (postorder.length == 1) {
            return new TreeNode(postorder[0]);
        }

        //切;

        int rootValue = postorder[postorder.length - 1];
        int index = 0;
        for (; index < inorder.length; index++) {
            if (inorder[index] == rootValue) {
                break;
            }
        }

//        System.out.println("index:" + index);
        TreeNode root = new TreeNode(rootValue);
        int[] inorder1 = Arrays.copyOfRange(inorder, 0, index);
        int[] postorder1 = Arrays.copyOfRange(postorder, 0, inorder1.length);
//        System.out.println("inorder1:" + Arrays.toString(inorder1));
//        System.out.println("postorder1:" + Arrays.toString(postorder1));

        int[] inorder2 = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] postorder2 = Arrays.copyOfRange(postorder, inorder1.length, postorder.length - 1);
//        System.out.println("inorder2:" + Arrays.toString(inorder2));
//        System.out.println("postorder2:" + Arrays.toString(postorder2));
        root.left = buildTree(inorder1, postorder1);
        root.right = buildTree(inorder2, postorder2);

        return root;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        No106 no106 = new No106();
        TreeNode treeNode = no106.buildTree(inorder, postorder);
        List<List<Integer>> list = TreeNodeCommonMethod.levelOrder(treeNode);
        System.out.println(list.toString());
    }
}
