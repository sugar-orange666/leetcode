package com.demo.no03;


import java.util.*;

public class No332 {

    public HashMap<String, TreeMap<String, Integer>> hashMap = new HashMap<>();

    List<String> result = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        init(tickets);
        result.add("JFK");
        backTracing(tickets);

        return result;
    }


    public boolean backTracing(List<List<String>> tickets) {
        if (result.size() >= tickets.size() + 1) {
            return true;
        }

        String last = result.get(result.size() - 1);
        if (hashMap.containsKey(last)) {
            TreeMap<String, Integer> treeMap = hashMap.get(last);
            for (Map.Entry<String, Integer> target : treeMap.entrySet()) {
                int count = target.getValue();
                if (count > 0) {
                    result.add(target.getKey());
                    target.setValue(count - 1);
                    boolean b = backTracing(tickets);
                    if (b) {
                        return true;
                    }
                    result.remove(result.size() - 1);
                    target.setValue(count);
                }
            }
        }
        return false;


    }


    public void init(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            TreeMap<String, Integer> treeMap = null;
            for (int i = 1; i < ticket.size(); i++) {
                treeMap = hashMap.getOrDefault(ticket.get(0), new TreeMap<>());
                treeMap.put(ticket.get(i), treeMap.getOrDefault(ticket.get(i), 0) + 1);
            }
            hashMap.put(ticket.get(0), treeMap);
        }


    }

    public static void main(String[] args) {
        No332 no332 = new No332();
        List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK", "SFO"),
                Arrays.asList("JFK", "ATL"),
                Arrays.asList("SFO", "ATL"),
                Arrays.asList("ATL", "JFK"),
                Arrays.asList("ATL", "SFO"));
////        List<List<String>> tickets = Arrays.asList(Arrays.asList("MUC", "LHR"),
////                Arrays.asList("JFK", "MUC"),
////                Arrays.asList("SFO", "SJC"),
////                Arrays.asList("LHR", "SFO"));
//        List<List<String>> tickets = Arrays.asList(Arrays.asList("JFK", "KUL"),
//                Arrays.asList("JFK", "NRT"),
//                Arrays.asList("NRT", "JFK"));
        System.out.println(no332.findItinerary(tickets));
    }
}
