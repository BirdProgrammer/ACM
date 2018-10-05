package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 16:56 2018/10/5
 * @ Description：LeetCode-206. Reverse Linked List
 */
public class ReverseLinkedList {

    // iteratively
    public ListNode reverseList(ListNode head) {
        ListNode ans = null;
        ListNode temp;

        while(head != null){
            temp = head;
            head = head.next;

            temp.next = ans;
            ans = temp;
        }
        return ans;
    }

    //recursively
    public ListNode reverseList_V2(ListNode head){
        if(head == null || head.next==null){
            return head;
        }else{
            ListNode temp = reverseList_V2(head.next);
            head.next.next = head;
            head.next = null;
            return temp;
        }
    }
}
