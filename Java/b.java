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
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;

        int count = 0;
        ListNode cur = head;
        while(cur != null){
            count++;
            cur = cur.next;
        }

        cur = head;
        int mid = count / 2;
        while(--mid > 0) cur = cur.next;
        cur.next = cur.next.next;

        return head;
    }
}
