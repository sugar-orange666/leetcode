package com.demo.no01;

import java.util.Arrays;

/**
 * 135. 分发糖果
 */
public class No135 {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        if (ratings.length == 1) {
            return 1;
        }

        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);

        //从前向后遍历
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
//        System.out.println(Arrays.toString(candy));

        //从后向前遍历
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }

        }

//        System.out.println(Arrays.toString(candy));


        return Arrays.stream(candy).sum();
    }


    public static void main(String[] args) {
        No135 no135 = new No135();
        System.out.println(no135.candy(new int[]{1, 3, 2, 2, 1}));
    }
}
