package com.jz_offer;

import com.common.ListNode;

public class LZ25 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode dummyNode=new ListNode(-1);
        ListNode pre=dummyNode;
        while(list1!=null&&list2!=null)
        {
            if(list1.val<=list2.val)
            {
                pre.next=list1;
                list1=list1.next;
            }else{
                pre.next=list2;
                list2=list2.next;
            }
            pre=pre.next;

        }

        pre.next=list1==null?list2:list1;
        return dummyNode.next;
    }
}
