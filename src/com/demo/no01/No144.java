package com.demo.no01;

import com.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class No144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(list,root);
        return list;
    }

    public void preOrder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(list,root.left);
        preOrder(list,root.right);
    }
}
