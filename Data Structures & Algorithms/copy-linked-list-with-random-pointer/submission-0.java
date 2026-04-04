/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        while(curr != null)
        {
            Node temp = new Node(curr.val);
            temp.next = curr.next;
            curr.next = temp;
            curr = curr.next.next;
        }

        curr = head;

        while(curr != null)
        {
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        curr = head;
        Node dummy = new Node(0);
        Node temp = dummy;
        while(curr != null)
        {
            temp.next = curr.next;
            curr.next = curr.next.next;
            curr = curr.next;
            temp = temp.next;
        }
        return dummy.next;
    }
}
