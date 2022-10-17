package com.demo.no02;

import java.util.*;

/**
 * 239. 滑动窗口最大值
 */
public class No239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //如果大于，删除前面的
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.add(i);
            //判断队首的元素是否有效
            if (deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            if (i >= k - 1) {
                res.add(nums[deque.peekFirst()]);
            }

        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        No239 no239 = new No239();
//        int[] ints = no239.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
//        System.out.println(Arrays.toString(ints));

        int[] ints1 = no239.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
//        int[] ints1 = no239.maxSlidingWindow(new int[]{7, 2, 4}, 2);
        System.out.println(Arrays.toString(ints1));
    }


}
