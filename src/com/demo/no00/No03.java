package com.demo.no00;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 *
 * @Date：2024/4/9 09:20
 * @Description
 */
public class No03 {

    //滑动窗口的解法
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                max = Math.max(max, map.size());
            } else {
                Integer tempIndex = map.get(s.charAt(i));
//                System.out.println("tempIndex:" + tempIndex);
                for (int j = start; j <= tempIndex; j++) {
                    map.remove(s.charAt(j));
                }

                map.put(s.charAt(i), i);
                start = tempIndex + 1;

            }

        }

        return max;
    }

    //这个方法容易理解，但是要注意：for循环，不要写j++,j++是在while循环内的
    //容易理解，感觉不好写
//    public int lengthOfLongestSubstring(String s) {
//        if (s.length() <= 1) {
//            return s.length();
//        }
//
//        int i = 0;
//        int res = Integer.MIN_VALUE;
//        HashSet<Character> set = new HashSet<>();
//        for (int j = 0; j < s.length(); ) {
//            while (j < s.length() && !set.contains(s.charAt(j))) {
//                set.add(s.charAt(j));
//                res = Math.max(res, j - i + 1);
//                j++;
//            }
//            set.remove(s.charAt(i));
//            i++;
//        }
//        return res;
//    }

    public static void main(String[] args) {
        No03 no03 = new No03();
        int res = no03.lengthOfLongestSubstring("abcbaefac");
        System.out.println(res);
    }
}
