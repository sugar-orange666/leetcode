package com.demo.no16;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * @Date：2023/8/30 14:25
 * @Description
 */
public class No1654 {
    int res = Integer.MAX_VALUE;
    HashSet<Integer> set;

    HashMap<Integer, Integer> hasWalk = new HashMap<>();

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
//        if (x >= forbidden.length) {
//            return -1;
//        }
        set = Arrays.stream(forbidden)
                .boxed()
                .collect(Collectors.toCollection(HashSet::new));

        backTracing(forbidden, a, b, x, 0, 0);
        hasWalk.put(0,1);
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    public void backTracing(int[] forbidden, int a, int b, int x, int curIndex, int curStep) {
        System.out.println("curIndex:" + curIndex);
        System.out.println("curStep:" + curStep);

//        if (curIndex >= forbidden.length || curIndex < 0) {
//            return false;
//        }


        if (curIndex < 0) {
            return;
        }
        //只能向后退一步
        if (curIndex > x + b) {
            return;
        }

        if (curIndex == x) {
            res = Math.min(res, curStep);
            return;
        }

        if (set.contains(curIndex)) {
            return;
        }
        //如果已经走过，则不用再走
        if (hasWalk.get(curIndex) != null && hasWalk.get(curIndex) == 1) {
            return;
        }

        hasWalk.put(curIndex + a, 1);
        backTracing(forbidden, a, b, x, curIndex + a, curStep + 1);
        hasWalk.remove(curIndex + a);
        hasWalk.put(curIndex - b, 1);
        backTracing(forbidden, a, b, x, curIndex - b, curStep + 1);
        hasWalk.remove(curIndex - b);

    }


    public static void main(String[] args) {
        No1654 no1654 = new No1654();
//        int res = no1654.minimumJumps(new int[]{0, 0, 0, 0, 0, 0, -1, 0}, 3, 2, 9);
//        int res = no1654.minimumJumps(new int[]{14, 4, 18, 1, 15}, 3, 15, 9);
//        int res = no1654.minimumJumps(new int[]{8, 3, 16, 6, 12, 2}, 15, 13, 11);
        int res = no1654.minimumJumps(new int[]{162, 118, 178, 152, 167, 100, 40, 74, 199, 186, 26, 73, 200, 127, 30, 124, 193, 84, 184, 36, 103, 149, 153, 9, 54, 154, 133, 95, 45, 198, 79, 157, 64, 122, 59,
                        71, 48, 177, 82, 35, 14, 176, 16, 108, 111, 6, 168, 31, 134, 164, 136, 72, 98},
                29, 98, 80);
        System.out.println(res);
    }
}
