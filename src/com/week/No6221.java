package com.week;

import java.util.*;
import java.util.stream.Collectors;

public class No6221 {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {

        List<List<String>> res = new ArrayList<>();
        //流行度
        HashMap<String, Long> popularMap = new HashMap<>();
        HashMap<String, Integer> maxIndexMap = new HashMap<>();
        int n = creators.length;

        for (int i = 0; i < n; i++) {
            popularMap.put(creators[i], popularMap.getOrDefault(creators[i], 0L) + views[i]);


            if (!maxIndexMap.containsKey(creators[i])) {
                maxIndexMap.put(creators[i], i);
            } else {
                Integer beforeIndex = maxIndexMap.get(creators[i]);
                //最大值
                if (views[i] > views[beforeIndex]) {
                    maxIndexMap.put(creators[i], i);
                } else if (views[i] == views[beforeIndex]) {
                    if (ids[i].compareTo(ids[beforeIndex]) < 0) {
                        maxIndexMap.put(creators[i], i);
                    }
                }


            }
        }

//        System.out.println("popularMap:" + popularMap);
//        System.out.println("maxIndexMap:" + maxIndexMap);

        //求map value的最大值
        ArrayList<Map.Entry<String, Long>> entries = new ArrayList<>(popularMap.entrySet());
        entries.sort((o1, o2) -> (int) (o2.getValue() - o1.getValue()));

//        System.out.println("entries:" + entries);

        Long max = -1L;
        for (Map.Entry<String, Long> entry : entries) {
            if (max == -1 || Objects.equals(entry.getValue(), max)) {
                max = entry.getValue();
                List<String> cur = new ArrayList<>();
                cur.add(entry.getKey());
                Integer idIndex = maxIndexMap.get(entry.getKey());
                cur.add(ids[idIndex]);
                res.add(cur);
            } else {
                break;
            }
        }

//        System.out.println(Arrays.toString(res.toArray()));
        return res;
    }

    public static void main(String[] args) {
        No6221 no6221 = new No6221();
//        System.out.println(no6221.mostPopularCreator(new String[]{"alice", "bob", "alice", "chris"},
//                new String[]{"one", "two", "three", "four"}, new int[]{5, 10, 5, 4}));
        System.out.println(no6221.mostPopularCreator(new String[]{"alice", "alice", "alice"},
                new String[]{"a", "b", "c"}, new int[]{1, 2, 2}));


    }
}
