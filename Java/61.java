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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode end = head, cur = head;
        int sz = 0;
        while(cur != null){
            cur = cur.next;
            sz++;
        }
        if (sz == 0 || k % sz == 0)
            return head;
        k %= sz;
        cur = head;
        for (int i = 0; i < k; i++){
            cur = cur.next;
        }
        while(cur.next != null){
            cur = cur.next;
            end = end.next;
        }

        ListNode nhead = end.next;
        end.next = null;
        cur.next = head;
        return nhead;
    }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        List<Integer> val = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            val.add(cur.val);
            cur = cur.next;
        }
        int i = 0, n = Math.max(1, val.size());
        k %= n;
        cur = head;
        while(cur != null){
            cur.val = val.get((-k + n + i++) % n);
            cur = cur.next;
        }
        return head;
    }
}
