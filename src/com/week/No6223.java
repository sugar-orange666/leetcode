package com.week;

import com.common.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

//todo 未ac
public class No6223 {
    public int[] treeQueries(TreeNode root, int[] queries) {
        //层序遍历
        //每个节点和子节点的值
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        //每一层每个节点的值
        HashMap<Integer, List<Integer>> orderMap = new HashMap<>();


        return null;
    }


    public static void levelOrder(TreeNode root, HashMap<Integer, List<Integer>> map, HashMap<Integer, Integer> orderMap) {

//        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return;
        }


//        orderMap.put(0, root.val);


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
//                    map.put(pop.val, pop.left.val);
                }
                if (pop.right != null) {
                    deque.addLast(pop.right);
                }
            }
//            res.add(cur);
        }
//        return res;

    }


}
