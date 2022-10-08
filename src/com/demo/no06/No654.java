package com.demo.no06;

import com.common.TreeNode;
import com.common.TreeNodeCommonMethod;

import java.util.Arrays;
import java.util.List;

/**
 * no654 最大二叉树
 */
public class No654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        //求最大值
        int maxIndex = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        int rootValue = max;
        TreeNode root = new TreeNode(rootValue);
        int[] leftArray = Arrays.copyOfRange(nums, 0, maxIndex);
        int[] rightArray = Arrays.copyOfRange(nums, maxIndex + 1, nums.length);
//        System.out.println("leftArray:" + Arrays.toString(leftArray));
//        System.out.println("rightArray:" + Arrays.toString(rightArray));
        root.left = constructMaximumBinaryTree(leftArray);
        root.right = constructMaximumBinaryTree(rightArray);

        return root;
    }

    public static void main(String[] args) {
        No654 no654 = new No654();
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        TreeNode treeNode = no654.constructMaximumBinaryTree(nums);
        List<List<Integer>> list = TreeNodeCommonMethod.levelOrder(treeNode);
        System.out.println(list.toString());
    }
}
