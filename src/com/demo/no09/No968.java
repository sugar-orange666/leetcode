package com.demo.no09;

import com.common.TreeNode;

/**
 * 968. 监控二叉树
 */
public class No968 {
    int res = 0;

    public int minCameraCover(TreeNode root) {

        //确定跟节点是否要添加
        if (minCame(root) == 0) {
            res++;
        }
        return res;

    }

    //0 无覆盖 1有摄像头 2有覆盖
    public int minCame(TreeNode root) {
        if (root == null) {
            //默认空节点为有覆盖的状态，避免在叶子节点放摄像头
            return 2;
        }

        int left = minCame(root.left);
        int right = minCame(root.right);

        //左右节点都覆盖
        if (left == 2 && right == 2) {
            return 0;
        } else if (left == 0 || right == 0) {
            //左右节点有一个无覆盖状态，跟节点应该安装摄像头
            res++;
            return 1;
        } else {
            //根节点被左右节点覆盖,左右节点至少存在一个摄像头
            return 2;
        }
    }


}
