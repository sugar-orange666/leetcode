package com.demo.no07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 763. 划分字母区间
 */
public class No763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> maxIndexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            //如果之前出现过，直接覆盖，相当于当前的就是最大的index
            maxIndexMap.put(s.charAt(i), i);
        }
        //最小的end结束的地方
        int curEnd = 0;
        int preIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == curEnd && maxIndexMap.get(s.charAt(i)) <= i) {
                res.add(i - preIndex + 1);
                preIndex = i + 1;
                curEnd = i + 1;
            } else {
                curEnd = Math.max(curEnd, maxIndexMap.get(s.charAt(i)));
            }
        }
        return res;
    }
}
