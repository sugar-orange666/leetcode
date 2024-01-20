package com.demo.no27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 2788. 按分隔符拆分字符串
 *
 * @Date：2024/1/20 14:45
 * @Description
 */

public class No2788 {
    //不能直接用pattern.quote 直接变换为正则，提交不了
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        if (words == null || words.size() <= 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();

        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == separator) {
                    String s = sb.toString().trim();
                    if (sb.length() != 0) {
                        res.add(s);
                        sb = new StringBuilder();
                    }
                }else {
                    sb.append(word.charAt(i));
                }
            }

            if (sb.toString().trim().length() != 0) {
                res.add(sb.toString().trim());
            }
        }


        return res;
    }



    public static void main(String[] args) {
        No2788 no2788 = new No2788();
//        List<String> list = no2788.splitWordsBySeparator(Arrays.asList("one.two.three", "four.five", "six"), '.');
//        List<String> list = no2788.splitWordsBySeparator(Arrays.asList("$easy$", "$problem$"), '$');
        List<String> list = no2788.splitWordsBySeparator(Arrays.asList("|||"), '|');
        System.out.println(list);
//        System.out.println(Arrays.toString("one.two.three".split("\\.")));
    }


}
