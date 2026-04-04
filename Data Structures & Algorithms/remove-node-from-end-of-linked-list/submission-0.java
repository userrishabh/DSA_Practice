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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode forwardNode = head;
        while(n>0)
        {
            forwardNode = forwardNode.next; 
            n--;
        }
        if(forwardNode == null) return head.next;

        while(forwardNode.next != null)
        {
            curr = curr.next;
            forwardNode = forwardNode.next;
        }
        curr.next = curr.next.next;
        return head;
    }
}
