package com.demo.no08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 813. 最大平均值和的分组
 *
 * @Date：2024/4/9 12:20
 * @Description
 */
public class No813 {

    //回溯超过时间限制
    public double largestSumOfAverages(int[] nums, int k) {
        return 0;
    }

    public static void main(String[] args) {
        No813 no813 = new No813();
//        double res = no813.largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3);
        double res = no813.largestSumOfAverages(new int[]{1, 2, 3, 4, 5, 6, 7}, 4);
        System.out.println(res);
    }
}
