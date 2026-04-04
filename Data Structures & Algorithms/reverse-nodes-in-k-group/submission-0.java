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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        int length = getLength(head);
        int count = 0;
        ListNode curr = head;
        ListNode prev = null;
        ListNode dummy = new ListNode(0);
        ListNode finalRes = dummy;
        ListNode endPoint = null;
        int possibleGroup = length/k;
        while(curr != null && possibleGroup > 0)
        {
            if (count == 0)
                endPoint = curr;
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            count++;
            if(count == k)
            {
                finalRes.next = prev;
                prev = null;
                finalRes = endPoint;
                count = 0;
                possibleGroup--;
            }
        }
        if(curr != null) finalRes.next = curr;
        return dummy.next;
    }

    public int getLength(ListNode node)
    {
        if(node == null) return 0;

        int count = 0;
        while(node != null)
        {
            count++;
            node = node.next;
        }
        return count;
    }
}
