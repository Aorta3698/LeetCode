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
        int count = 0;
        ListNode cur = head;

        while(count < k && cur != null){
            count++;
            cur = cur.next;
        }

        if (count == k){
            ListNode nHead = reverse(head, k);
            head.next = reverseKGroup(cur, k);
            return nHead;
        }

        return head;
    }

    private ListNode reverse(ListNode head, int n){
        ListNode nHead = null;
        ListNode cur = head;

        while(n-- > 0){
            ListNode tmp = cur.next;
            cur.next = nHead;
            nHead = cur;
            cur = tmp;
        }

        return nHead;
    }
}
