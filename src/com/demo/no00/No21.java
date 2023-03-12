package com.demo.no00;

import com.common.ListNode;

import java.util.Arrays;

/**
 * 21. 合并两个有序链表
 */
public class No21 {


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode tail = dummyNode;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                tail.next = cur1;
                cur1 = cur1.next;
            } else {
                tail.next = cur2;
                cur2 = cur2.next;
            }
            tail = tail.next;
        }

        if (cur1 != null) {
            tail.next = cur1;
        }
        if (cur2 != null) {
            tail.next = cur2;
        }


        return dummyNode.next;
    }


    public static void main(String[] args) {
        No21 no21 = new No21();
        ListNode node1 = ListNode.createListByArray(new int[]{1, 2, 4});
        ListNode node2 = ListNode.createListByArray(new int[]{1, 3, 4});


        ListNode node = no21.mergeTwoLists(node1, node2);
        ListNode.print(node);
    }
}

