package com.demo.no08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 884. 两句话中的不常见单词
 *
 * @Date：2024/3/28 13:11
 * @Description
 */
public class No884 {

    public String[] uncommonFromSentences(String s1, String s2) {


        HashMap<String, Integer> map = new HashMap<>();
        map = getMap(s1, map);
        map = getMap(s2, map);


        List<String> res = new ArrayList<>();

        for (String s : map.keySet()) {
            if (map.get(s) <= 1) {
                res.add(s);
            }
        }

        return res.toArray(new String[0]);

    }

    public HashMap<String, Integer> getMap(String s, HashMap<String, Integer> map) {
//        HashMap<String, Integer> map = new HashMap<>();
        s = s.trim();
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            map.put(split[i], map.getOrDefault(split[i], 0) + 1);
        }
        return map;

    }

    public static void main(String[] args) {
        No884 no884 = new No884();
        String[] strings = no884.uncommonFromSentences("this apple is sweet", "this apple is sour");
        System.out.println(Arrays.toString(strings));
    }
}
