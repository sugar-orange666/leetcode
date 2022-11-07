package com.demo.no01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 139. 单词拆分
 */
public class No139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            //dp 和s的起始位置不一样
            for (int j = 0; j <= i; j++) {
                //字符串存在，之前的字符串也能拼出来，当前才会赋值为true
                if (set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
            }
//            System.out.println(Arrays.toString(dp));
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        No139 no139 = new No139();
        System.out.println(no139.wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(no139.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(no139.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
//        System.out.println("abc".substring(0, 2));
    }
}
