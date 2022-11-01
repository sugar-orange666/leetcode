package com.demo.no04;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 406. 根据身高重建队列
 */
public class No406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                //相同身高，按照k升序
                return a[1] - b[1];
            }
            //身高降序
            return b[0] - a[0];
        });

        LinkedList<int[]> res = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            //在哪一个位置添加哪个元素
            res.add(people[i][1], people[i]);
        }

        return res.toArray(new int[people.length][]);

    }

    public static void main(String[] args) {
        No406 no406 = new No406();
        int[][] queue = no406.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        for (int i = 0; i < queue.length; i++) {
            for (int j = 0; j < queue[0].length; j++) {
                System.out.println(queue[i][j]);
            }
        }

    }
}
