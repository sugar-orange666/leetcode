package com.demo.no00;

import com.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class No98_1 {

    public List<Integer> path = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        getPath(root);

        for (int i = 0; i < path.size() - 1; i++) {
            if (path.get(i) >= path.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public void getPath(TreeNode root) {
        if (root == null) {
            return;
        }
        getPath(root.left);
        path.add(root.val);
        getPath(root.right);
    }
}
