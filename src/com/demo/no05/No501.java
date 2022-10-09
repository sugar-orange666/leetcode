package com.demo.no05;

import com.common.TreeNode;
import com.common.TreeNodeCommonMethod;

import java.util.*;

/**
 * no501. 二叉搜索树中的众数
 */
public class No501 {
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    public int[] findMode(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root);

        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(hashMap.entrySet());
        //降序排列
//        System.out.println("entries:" + entries.toString());
        entries.sort((o1, o2) -> (o2.getValue() - o1.getValue()));
//        System.out.println("entries:" + entries.toString());
        Integer maxValue = entries.get(0).getValue();
//        System.out.println("maxValue:" + maxValue);
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (Objects.equals(entry.getValue(), maxValue)) {
                res.add(entry.getKey());
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        hashMap.put(root.val, hashMap.getOrDefault(root.val, 0) + 1);
        dfs(root.right);
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{1,2,2};
        int[] postOrder = new int[]{2,2,1};
        TreeNode treeNode = TreeNodeCommonMethod.buildTree(inorder, postOrder);
        No501 no501=new No501();
        int[] mode = no501.findMode(treeNode);
        System.out.println(Arrays.toString(mode));

    }

}
