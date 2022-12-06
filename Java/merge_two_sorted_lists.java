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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l2.val < l1.val) return mergeTwoLists(l2, l1);

        ListNode head = l1;

        while(l1.next != null && l1.next.val < l2.val)
            l1 = l1.next;

        ListNode copy = l1.next;
        l1.next = l2;
        l2.next = mergeTwoLists(copy, l2.next);

        return head;
    }
}
