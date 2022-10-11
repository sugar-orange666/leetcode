package com.demo.no01;

import com.common.TreeNode;
import com.common.TreeNodeCommonMethod;

import java.util.Arrays;
import java.util.List;

/**
 * 108. 将有序数组转换为二叉搜索树
 */
public class No108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid + 1, nums.length);
        root.left = sortedArrayToBST(left);
        root.right = sortedArrayToBST(right);
        return root;

    }

    public static void main(String[] args) {
        No108 no108 = new No108();
        int[] a = new int[]{-10, -3, 0, 5, 9};
        TreeNode treeNode = no108.sortedArrayToBST(a);
        List<List<Integer>> list = TreeNodeCommonMethod.levelOrder(treeNode);
        System.out.println(list);

    }
}
