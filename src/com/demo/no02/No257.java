package com.demo.no02;

import com.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class No257 {

    public List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return result;
        }
        getPath(root, "");
        return result;
    }

    public void getPath(TreeNode treeNode, String path) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.left == null && treeNode.right == null) {
            path = path + treeNode.val;
            result.add(path);
            return;
        }
        path += path + treeNode.val + "->";
        getPath(treeNode.left, path);
        getPath(treeNode.right, path);
    }
}
