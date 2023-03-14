package com.demo.no00;

import com.common.ListNode;
import org.w3c.dom.ls.LSException;

/**
 * 合并两个无序的链表
 */
public class No21_1 {


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node1 = mergeSort(list1);
        ListNode node2 = mergeSort(list2);
        ListNode.print(node1);
        ListNode.print(node2);
        return merge(node1, node2);
    }

    //链表的排序,归并排序
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //slow要是虚拟头节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode fast = head;
        ListNode slow = dummyNode;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rNode = slow.next;
        slow.next = null;
        ListNode lSort = mergeSort(head);
        System.out.printf("LSort:");
        ListNode.print(lSort);
        ListNode rSort = mergeSort(rNode);
        System.out.printf("RSort:");
        ListNode.print(rSort);
        return merge(lSort, rSort);

    }


    public ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode cur1 = node1;
        ListNode cur2 = node2;
        ListNode tail = dummyNode;

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
        No21_1 no21_1 = new No21_1();
        ListNode node1 = ListNode.createListByArray(new int[]{3, 2, 1, 4});
        ListNode node2 = ListNode.createListByArray(new int[]{4, 5, 2, 3});
        ListNode node = no21_1.mergeTwoLists(node1, node2);

        ListNode.print(node);
    }

}
