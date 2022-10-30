package com.demo.no04;

import java.util.Arrays;

/**
 * no455 分发饼干
 */
public class No455 {
    public int findContentChildren(int[] g, int[] s) {
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int sIndex = 0;
        for (int i = 0; i < g.length; i++) {
            while (sIndex < s.length && s[sIndex] < g[i]) {
                sIndex++;
            }

            if (sIndex >= s.length) {
                break;
            }

            if (s[sIndex] >= g[i]) {
                count++;
                sIndex++;
            }

        }
        return count;
    }


    public static void main(String[] args) {
        No455 no455 = new No455();
//        System.out.println(no455.findContentChildren(new int[]{3, 5, 6}, new int[]{1, 4, 7}));
//        System.out.println(no455.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
        System.out.println(no455.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
    }
}
