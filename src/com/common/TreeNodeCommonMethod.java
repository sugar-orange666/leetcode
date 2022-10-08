package com.common;

import com.demo.no01.No106;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeNodeCommonMethod {
    //层序遍历
    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);


        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode pop = deque.pop();
                cur.add(pop.val);
                if (pop.left != null) {
                    deque.addLast(pop.left);
                }
                if (pop.right != null) {
                    deque.addLast(pop.right);
                }
            }
            res.add(cur);
        }
        return res;

    }

    /**
     * 中序和后序构造二叉树
     * @param inorder 中序
     * @param postorder 后序
     * @return 树的根节点
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        No106 no106 = new No106();
        return no106.buildTree(inorder, postorder);
    }
}
