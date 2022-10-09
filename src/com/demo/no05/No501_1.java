package com.demo.no05;

import com.common.TreeNode;
import com.common.TreeNodeCommonMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No501_1 {

    private int curCount = 0;
    private int maxCount = Integer.MIN_VALUE;

    private TreeNode pre = null;
    private List<Integer> res = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        dfs(root);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }


    public void dfs(TreeNode root) {

        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == null || pre.val != root.val) {
            curCount = 1;
        } else {
            curCount++;
        }
        pre = root;
        if (curCount == maxCount) {
            res.add(root.val);
        }
        if (curCount > maxCount) {
            maxCount = curCount;
            res.clear();
            res.add(root.val);
        }
//        if (pre != null) {
//            System.out.println("pre.value:" + pre.val);
//        }
//
//        System.out.println("root.value:" + root.val);
//        System.out.println("maxCount:" + maxCount);
//        System.out.println("curCount:" + curCount);
        dfs(root.right);
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{0, 0, 0, 0, 1, 1, 1, 1};
        int[] postOrder = new int[]{0, 0, 0, 0, 1, 1, 1, 1};
        TreeNode treeNode = TreeNodeCommonMethod.buildTree(inorder, postOrder);
        No501_1 no501 = new No501_1();
        int[] mode = no501.findMode(treeNode);
        System.out.println(Arrays.toString(mode));

    }

}
