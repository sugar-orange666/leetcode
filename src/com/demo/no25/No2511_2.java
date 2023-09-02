package com.demo.no25;

/**
 * 2511. 最多可以摧毁的敌人城堡数目
 * @Date：2023/9/2 13:28
 * @Description
 */
public class No2511_2 {
    //求-1 和1 之间的最大距离，1和-1之间表示正向遍历 -1和1之间表示反向遍历
    public int captureForts(int[] forts) {
        int res = 0;
        int start = -1;
        for (int i = 0; i < forts.length; i++) {
            if (forts[i] == 1 || forts[i] == -1) {
                if (start >= 0 && forts[i] != forts[start]) {
                    res = Math.max(res, i - start - 1);
                }
                start = i;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        No2511_2 test = new No2511_2();
        System.out.println(test.captureForts(new int[]{1, 0, 0, -1, 0, 0, 0, 0, 1}));
        System.out.println(test.captureForts(new int[]{0, 0, 1, -1}));
    }
}
