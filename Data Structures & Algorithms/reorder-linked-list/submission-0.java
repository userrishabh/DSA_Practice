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
    public void reorderList(ListNode head) {
        ListNode curr = head;
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while(fastPointer != null && fastPointer.next != null)
        {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        ListNode prev = null;
        ListNode secondHalfList = slowPointer.next;
        slowPointer.next = null;
        while(secondHalfList != null)
        {
            ListNode temp = secondHalfList.next;
            secondHalfList.next = prev;
            prev = secondHalfList;
            secondHalfList = temp;
        }
        while(prev != null && curr != null)
        {
            ListNode temp = curr.next;
            ListNode tempPrev = prev.next;
            curr.next = prev;
            prev.next = temp;
            curr = temp;
            prev = tempPrev;
        }
    }
}
