package com.demo.no00;

import com.common.ListNode;

import java.util.PriorityQueue;

/**
 * 23. 合并K个升序链表
 */
public class No23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });

        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.add(list);
            }
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode tail = dummyNode;
        while (!priorityQueue.isEmpty()) {
            ListNode poll = priorityQueue.poll();
            tail.next = poll;
            if (poll.next != null) {
                priorityQueue.add(poll.next);
            }
            tail = tail.next;
        }


        return dummyNode.next;
    }
}
