package com.jz_offerII;

import com.common.ListNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 剑指 Offer II 031. 最近最少使用缓存
 * 方法一：删除的时间复杂度在O(n)级别
 */
public class JZTwo31 {


    ConcurrentHashMap<Integer, Integer> cacheMap;
    LinkedList<Integer> lruList = new LinkedList<>();

    int capacity;


    public JZTwo31(int capacity) {
        cacheMap = new ConcurrentHashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {


        Integer value = cacheMap.get(key);
        if (value == null) {
            return -1;
        }
        //移除之后，添加到最后面
        removeAndAdd(lruList, key);
        return value;
    }

    public void put(int key, int value) {

        if (cacheMap.containsKey(key)) {
            cacheMap.put(key, value);
            removeAndAdd(lruList, key);
            return;
        }

        if (cacheMap.size() == capacity) {
            Integer pop = lruList.removeLast();
            cacheMap.remove(pop);
        }
        cacheMap.put(key, value);
        removeAndAdd(lruList, key);

    }


    public void removeAndAdd(LinkedList<Integer> lruList, int num) {
        lruList.remove((Integer) num);
        lruList.addFirst(num);
    }

    public void print() {
        System.out.println("lruList:" + lruList.toString());
        System.out.println("mapList:" + cacheMap.toString());
    }


    public static void main(String[] args) {
        JZTwo31 jzTwo31 = new JZTwo31(2);
        System.out.println(jzTwo31.get(2));
        jzTwo31.put(2, 6);
        System.out.println(jzTwo31.get(1));
        jzTwo31.put(1, 5);
        jzTwo31.print();
        jzTwo31.put(1, 2);
        jzTwo31.print();
        LinkedList<ListNode> res = new LinkedList<>();

    }


}
