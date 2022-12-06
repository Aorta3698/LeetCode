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
    public ListNode swapPairs(ListNode head) {
        return helper(null, head);
    }

    private ListNode helper(ListNode prev, ListNode head){
        if (head == null || head.next == null) return head;

        ListNode tmp = new ListNode();
        tmp.next = head.next;
        head.next = head.next.next;
        tmp.next.next = head;
        head = tmp.next;
        if (prev != null) prev.next = head;

        helper(head.next, head.next.next);

        return head;
    }
}
