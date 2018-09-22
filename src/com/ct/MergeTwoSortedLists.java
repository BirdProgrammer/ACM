package com.ct;


/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 21:23 2018/9/22
 * @ Description：LeetCode-21. Merge Two Sorted Lists
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode head = ans;
        ListNode temp;
        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                temp = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                temp = new ListNode(l2.val);
                l2 = l2.next;
            }
            ans.next = temp;
            ans = temp;
        }
        if(l1 == null){
            ans.next = l2;
        }else{
            ans.next = l1;
        }
        return head.next;
    }

    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
