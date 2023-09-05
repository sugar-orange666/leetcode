package com.demo.no19;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 1921. 消灭怪物的最大数量
 *
 * @Date：2023/9/3 09:18
 * @Description
 */
public class No1921 {

    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] arrivalTimes = new int[n];
        for (int i = 0; i < n; i++) {
            //取整
            arrivalTimes[i] = (dist[i] - 1) / speed[i] + 1;
        }
        Arrays.sort(arrivalTimes);
        System.out.println(Arrays.toString(arrivalTimes));

        for (int i = 0; i < n; i++) {
            //必须比i大才能走到i
            if (arrivalTimes[i] <= i) {
                return i;
            }
        }
        return n;
    }


//    public int eliminateMaximum(int[] dist, int[] speed) {
//        int[] count = new int[dist.length];
//        for (int i = 0; i < dist.length; i++) {
//            //至少在第几秒要被消灭
//            int time = (dist[i] - 1) / speed[i] ;
//            if (time < dist.length) {
//                //time时间段内消灭的怪物的数量
//                count[time]++;
//            }
//        }
//
//        System.out.println(Arrays.toString(count));
//        int kill=0;
    //每秒可以消灭一个，计数
//        for (int i = 0; i < dist.length; i++) {
//            //消灭的数量不能等于大于i
//            kill++;
//            kill-=count[i];
//            if(kill<0)
//            {
//                return i+1;
//            }
//        }
//        return dist.length;
//
//    }

    public static void main(String[] args) {
        No1921 test = new No1921();
//        System.out.println(test.eliminateMaximum(new int[]{3, 1, 2, 7}, new int[]{2, 8, 3, 1}));
        System.out.println(test.eliminateMaximum(new int[]{1, 3, 4}, new int[]{1, 1, 1}));
        System.out.println(test.eliminateMaximum(new int[]{1, 1, 2, 3}, new int[]{1, 1, 1, 1}));
        System.out.println(test.eliminateMaximum(new int[]{3, 2, 4}, new int[]{5, 3, 2}));
        System.out.println(test.eliminateMaximum(new int[]{4, 2, 3}, new int[]{2, 1, 1}));
    }
}
