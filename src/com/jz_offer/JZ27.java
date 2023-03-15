package com.jz_offer;

import com.common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 剑指 Offer II 027. 回文链表
 */
public class JZ27 {

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        System.out.println(list);
        return isPalindromeList(list);
    }


    public boolean isPalindromeList(List<Integer> list) {
        int i = 0, j = list.size() - 1;
        while (i < j) {
            if (!Objects.equals(list.get(i), list.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static void main(String[] args) {
        JZ27 jz27 = new JZ27();
        boolean palindrome = jz27.isPalindrome(ListNode.createListByArray(new int[]{1, 2, 3, 3, 2, 1}));
        System.out.println(palindrome);
    }


}
