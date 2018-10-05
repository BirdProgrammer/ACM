package com.ct;

import java.util.List;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 10:36 2018/9/12
 * @ Description：LeetCode-86. Partition List
 */
public class PartitionList {

    public static void main(String[] args){
        PartitionList partitionList = new PartitionList();
    }

    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode greaterOrEqual = new ListNode(0);
        ListNode lessHead = less;
        ListNode greaterOrEqualHead = greaterOrEqual;
        while(head != null){
            if(head.val < x){
                ListNode temp = new ListNode(head.val);
                less.next = temp;
                less = less.next;
            }else{
                ListNode temp = new ListNode(head.val);
                greaterOrEqual.next = temp;
                greaterOrEqual = greaterOrEqual.next;
            }
            head = head.next;
        }
        less.next = greaterOrEqualHead.next;
        return lessHead.next;
    }
}


