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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        ListNode cur = head;
        int sz = 0;

        while(cur != null){
            sz++;
            cur = cur.next;
        }

        int each = sz / k;
        int extra = sz - each * k;
        cur = head;
        for (int i = 0; i < k; i++, extra--){
            ans[i] = cur;
            for (int j = 0; j < each - 1 + (extra > 0? 1 : 0); j++){
                cur = cur.next;
            }
            if (cur != null){
                head = cur.next;
                cur.next = null;
                cur = head;
            }
        }

        return ans;
    }
}
