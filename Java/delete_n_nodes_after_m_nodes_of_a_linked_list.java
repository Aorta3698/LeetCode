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
https://leetcode.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/discuss/1632076/Java-or-Recursive-Solution-or-8-Lines
class Solution {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        if (head == null) return head;
        ListNode cur = head;
        int mm = m, nn = n;
        while(--mm > 0 && cur.next != null) cur = cur.next;
        ListNode tail = cur;
        while(--nn >= 0 && cur.next != null) cur = cur.next;
        tail.next = deleteNodes(cur.next, m, n);
        return head;
    }
}
