package com.demo.no03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 347. 前 K 个高频元素
 */
public class No347_1 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
        //小顶堆
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        for (Integer integer : hashMap.keySet()) {
            Integer value = hashMap.get(integer);
            //小于堆的大小，直接加入
            if (priorityQueue.size() < k) {
                priorityQueue.add(new int[]{integer, value});
            } else {
                int[] peek = priorityQueue.peek();
                if (value > peek[1]) {
                    priorityQueue.poll();
                    priorityQueue.add(new int[]{integer, value});
                }
            }
        }
        int[] res = new int[k];
        int i = k - 1;
        for (int[] ints : priorityQueue) {
            res[i] = ints[0];
            i--;
        }

        return res;
    }

    public static void main(String[] args) {
        No347_1 no347_1 = new No347_1();
        int[] res = no347_1.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(res));
    }
}
