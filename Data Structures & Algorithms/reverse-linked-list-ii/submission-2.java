/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0,head);
        ListNode res = dummy;

        for(int i=0; i<left-1; i++)
        {
            res = res.next;
        }
        ListNode hold = res.next;
        ListNode curr = hold.next;
        ListNode prev = hold;
        for(int i=0; i<right-left; i++)
        {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        hold.next = curr;
        res.next = prev;
        return dummy.next;
    }
}