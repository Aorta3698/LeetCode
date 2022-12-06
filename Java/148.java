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
    public ListNode sortList(ListNode head) {
        int o = 100000;
        int[] buckets = new int[2*o + 1];
        int min = 2*o, max = 0;
        ListNode cur = head;
        while(cur != null){
            int g = cur.val + o;
            buckets[g]++;
            min = Math.min(g, min);
            max = Math.max(g, max);
            cur = cur.next;
        }

        cur = head;
        while(min <= max){
            cur.val = min - o;
            cur = cur.next;
            --buckets[min];
            while (min <= max && buckets[min] == 0) min++;
        }

        return head;
    }
}
