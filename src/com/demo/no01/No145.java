package com.demo.no01;

import com.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class No145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(list, root);
        return list;
    }

    public void inOrder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(list, root.left);
        list.add(root.val);
        inOrder(list, root.right);
    }
}
