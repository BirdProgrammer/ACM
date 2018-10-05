package com.ct;

/**
 * @ Author     ：Cao Tuo
 * @ Date       ：Created in 22:52 2018/9/19
 * @ Description：LeetCode-203. Remove Linked List Elements
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode ans = new ListNode(val-1);
        ans.next = head;
        head = ans;
        while(head.next != null){
            if(head.next.val == val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        return ans.next;
    }
}
