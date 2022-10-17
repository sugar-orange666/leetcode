package com.jz_offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 041. 滑动窗口的平均值
 */
public class JZ41 {

    int curSum = 0;
    int num;


    Deque<Integer> list;

    public JZ41(int size) {
        this.num = size;
        list = new LinkedList<>();
    }

    public double next(int val) {
        System.out.println("num:"+num);
        list.addLast(val);
        curSum += val;
        if (!list.isEmpty() && list.size() > num) {
            Integer integer = list.pollFirst();
            curSum -= integer;
        }
        return (double) curSum / list.size();


    }

    public static void main(String[] args) {
        System.out.println( 1.0/3);
    }


}
