package com.demo.no28;

import java.util.Arrays;
import java.util.List;

/**
 * 2859. 计算 K 置位下标对应元素的和
 * @Date：2024/1/25 18:28
 * @Description
 */
public class No2859 {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (bitCount(i) == k) {
                res += nums.get(i);
            }
        }
        return res;
    }

    public int bitCount(int x) {
        int cnt = 0;
        while (x != 0) {
            //最后一位是不是1
            cnt += (x % 2);
            //去掉最后一位
            x /= 2;
        }
        return cnt;
    }

    public static void main(String[] args) {
        No2859 test = new No2859();
//        System.out.println(test.sumIndicesWithKSetBits(Arrays.asList(5, 10, 1, 5, 2),1));
//        System.out.println(test.sumIndicesWithKSetBits(Arrays.asList(1), 0));
//        System.out.println(1 << 0 - 1);
        System.out.println(test.bitCount(9));

    }

}
