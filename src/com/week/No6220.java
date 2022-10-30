package com.week;

public class No6220 {
    public int averageValue(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Long sum = 0L;
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] % 3 == 0) && (nums[i] % 2 == 0)) {
                sum += nums[i];
                num++;
            }
        }

        return num == 0 ? 0 : (int) (sum / num);
    }

    public static void main(String[] args) {
        No6220 no6220 = new No6220();
//        System.out.println(no6220.averageValue(new int[]{1, 3, 6, 10, 12, 15}));
//        System.out.println(no6220.averageValue(new int[]{1, 2, 4, 7, 10}));
        System.out.println(no6220.averageValue(new int[]{4,4,9,10}));
    }
}
