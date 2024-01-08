package com.demo.no02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 210. 课程表 II
 *
 * @Date：2023/9/10 09:22
 * @Description
 */
public class No210 {
    //思路：遍历两遍 第一遍确定位置，交换，第二遍在判断是否符合条件
    //key 值 value index
    HashMap<Integer, Integer> map = new HashMap<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        for (int i = 0; i < res.length; i++) {
            res[i] = i;
            map.put(res[i], i);
        }
        if (prerequisites.length == 0) {
            return res;
        }

        System.out.println(Arrays.toString(res));
        for (int i = 0; i < prerequisites.length; i++) {
            int leftIndex = map.get(prerequisites[i][0]);
            int rightIndex = map.get(prerequisites[i][1]);
            //右边的在左边的前面，所以右边的Index应该小于左边，如果大于，则交换
            //如果两个都不为空，则交换位置
            if (leftIndex < rightIndex) {
                swap(res, leftIndex, rightIndex);
                map.put(prerequisites[i][0], rightIndex);
                map.put(prerequisites[i][1], leftIndex);
            }

        }


        System.out.println(map.toString());

        for (int i = 0; i < prerequisites.length; i++) {
            int leftIndex = map.get(prerequisites[i][0]);
            int rightIndex = map.get(prerequisites[i][1]);
            //右边的在左边的前面，所以右边的Index应该小于左边，如果大于，则交换
            if (leftIndex < rightIndex) {
                return new int[]{};
            }
        }
        return res;
    }


    public void swap(int[] res, int index1, int index2) {
        int temp = res[index1];
        res[index1] = res[index2];
        res[index2] = temp;
    }

    public static void main(String[] args) {
        No210 test = new No210();
        System.out.println(Arrays.toString(test.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
    }
}
