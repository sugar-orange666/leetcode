package com.demo.no00;

import java.util.*;

/**
 * 49. 字母异位词分组
 */
public class No49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(strs[i]);
            map.put(key, list);

        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        No49 no49 = new No49();
        List<List<String>> lists = no49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }
}
