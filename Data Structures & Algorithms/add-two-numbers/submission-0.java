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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        int remaining = 0;

        while(l1 != null || l2 != null)
        {
            int sum = remaining;
            if(l1 != null)
            {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null)
            {
                sum+=l2.val;
                l2 = l2.next;
            }
            int remainder = sum%10;
            remaining = sum/10;

            res.next = new ListNode(remainder);
            res = res.next;
        }

        if(remaining != 0)
            res.next = new ListNode(remaining);

        return dummy.next;
    }
}
