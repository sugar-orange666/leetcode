package com.demo.no06;

import com.common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.pop();
                sum += cur.val;
                if (cur.left != null) {
                    deque.addLast(cur.left);
                }
                if (cur.right != null) {
                    deque.addLast(cur.right);
                }
            }
            res.add((double) sum / size);
        }
        return res;

    }
}
