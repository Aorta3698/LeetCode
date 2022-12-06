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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode cur = head, second = head, first = head;
        while(--k > 0){
            cur = cur.next;
        }
        first = cur;
        while(cur.next != null){
            second = second.next;
            cur = cur.next;
        }

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;

        return head;
    }
}
