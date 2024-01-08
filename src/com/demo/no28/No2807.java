package com.demo.no28;

import com.common.ListNode;

import java.util.List;

/**
 * 2807. 在链表中插入最大公约数
 *
 * @Date：2024/1/6 17:11
 * @Description
 */
public class No2807 {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        ListNode q = head.next;

        while (q != null) {
            int divisor = getMaxCommonDivisor(p.val, q.val);
            ListNode node = new ListNode(divisor);
            p.next = node;
            node.next = q;
            p = q;
            q = p.next;
        }
        return head;
    }


    //获取最大公约数
    //欧几里德法 a=bq+r
    //k1*c=k2*c*q+r
    //r必然是k3*c
    //所以a,b的最大公约数可以转换为求b和r的最大公约数
    //a是a,b两数字中最大的哪一个，如果刚开始不是，经过一次循环之后也会变为最大的那一个
    public int getMaxCommonDivisor(int a, int b) {
        //确保x是两数中的最大的
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }


    public static void main(String[] args) {
        No2807 no2807 = new No2807();
        ListNode head = ListNode.createListByArray(new int[]{10, 25, 30});
//        int maxCommonDivisor = no2807.getMaxCommonDivisor(27, 10);
//        System.out.println(maxCommonDivisor);
        no2807.insertGreatestCommonDivisors(head);
        ListNode.print(head);
    }
}
