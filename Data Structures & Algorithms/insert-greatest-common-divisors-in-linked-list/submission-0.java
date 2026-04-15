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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode resNode = head;

        while(resNode.next != null)
        {
            ListNode temp = resNode.next;

            int hcf = gcd(resNode.val, temp.val);

            ListNode gcdNode = new ListNode(hcf, temp);
            resNode.next = gcdNode;
            resNode = temp;
        }

        return head;
    }

    int gcd(int x, int y)
    {
        if(y==0) return x;

        return gcd(y, x%y);
    }
}