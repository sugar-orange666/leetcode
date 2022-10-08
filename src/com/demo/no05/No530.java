package com.demo.no05;

import com.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class No530 {

    private List<Integer> list = new ArrayList<>();


    public int getMinimumDifference(TreeNode root) {

        int min = Integer.MAX_VALUE;
        dfs(root);
        for (int i = 0; i < list.size() - 1; i++) {
            int cur = Math.abs(list.get(i) - list.get(i + 1));
            min = Math.min(min, cur);
        }
        return min;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

}
