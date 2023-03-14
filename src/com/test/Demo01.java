package com.test;

import com.common.CommonArray;
import com.common.ListNode;
import com.common.TreeNode;
import com.common.TreeNodeCommonMethod;
import com.sun.source.tree.Tree;

import java.util.*;

public class Demo01 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }

        //左
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //右
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //根
        if (left != null && right != null) {
            return root;
        } else if (left == null && right != null) {
            return right;
        } else if (right == null && left != null) {
            return left;
        } else {
            return null;
        }

    }


    public static void main(String[] args) {

    }

}
